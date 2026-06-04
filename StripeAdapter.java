package br.com.projeto.adapter;

import br.com.projeto.annotation.GatewayAdapter;
import br.com.projeto.legado.StripeApi;

@GatewayAdapter(nome = "stripe")
public class StripeAdapter implements PagamentoAdapter {

    private final StripeApi stripeApi;

    public StripeAdapter() {
        this.stripeApi = new StripeApi();
    }

    @Override
    public void pagar(double valor) {
        stripeApi.charge(valor);
    }
}
