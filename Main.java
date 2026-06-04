package br.com.projeto;

import br.com.projeto.adapter.PagamentoAdapter;
import br.com.projeto.factory.GatewayFactory;
import br.com.projeto.sistema.CheckoutService;

public class Main {

    public static void main(String[] args) {
        String gatewayEscolhido = args.length > 0 ? args[0] : "paypal";

        PagamentoAdapter adapter = GatewayFactory.criar(gatewayEscolhido);
        CheckoutService checkout = new CheckoutService(adapter);

        checkout.finalizarCompra(250.00);
    }
}
