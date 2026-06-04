package br.com.projeto.adapter;

import br.com.projeto.annotation.GatewayAdapter;
import br.com.projeto.legado.PayPalApi;

@GatewayAdapter(nome = "paypal")
public class PayPalAdapter implements PagamentoAdapter {

    private final PayPalApi payPalApi;

    public PayPalAdapter() {
        this.payPalApi = new PayPalApi();
    }

    @Override
    public void pagar(double valor) {
        payPalApi.realizarPagamentoPayPal(valor);
    }
}
