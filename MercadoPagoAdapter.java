package br.com.projeto.adapter;

import br.com.projeto.annotation.GatewayAdapter;
import br.com.projeto.legado.MercadoPagoApi;

@GatewayAdapter(nome = "mercadopago")
public class MercadoPagoAdapter implements PagamentoAdapter {

    private final MercadoPagoApi mercadoPagoApi;

    public MercadoPagoAdapter() {
        this.mercadoPagoApi = new MercadoPagoApi();
    }

    @Override
    public void pagar(double valor) {
        mercadoPagoApi.processarPagamentoMercadoPago(valor);
    }
}
