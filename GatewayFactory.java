package br.com.projeto.factory;

import br.com.projeto.adapter.PagamentoAdapter;
import br.com.projeto.annotation.GatewayAdapter;

import java.util.List;

public class GatewayFactory {

    private static final List<Class<? extends PagamentoAdapter>> ADAPTERS = List.of(
            br.com.projeto.adapter.PayPalAdapter.class,
            br.com.projeto.adapter.MercadoPagoAdapter.class,
            br.com.projeto.adapter.StripeAdapter.class
    );

    public static PagamentoAdapter criar(String nomeGateway) {
        for (Class<? extends PagamentoAdapter> classe : ADAPTERS) {

            if (classe.isAnnotationPresent(GatewayAdapter.class)) {
                GatewayAdapter anotacao = classe.getAnnotation(GatewayAdapter.class);

                if (anotacao.nome().equalsIgnoreCase(nomeGateway)) {
                    try {
                        return classe.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException("Erro ao criar adapter: " + classe.getName(), e);
                    }
                }
            }
        }

        throw new IllegalArgumentException("Gateway não encontrado: " + nomeGateway);
    }
}
