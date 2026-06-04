package br.com.projeto.sistema;

import br.com.projeto.adapter.PagamentoAdapter;

public class CheckoutService {

    private final PagamentoAdapter pagamentoAdapter;

    public CheckoutService(PagamentoAdapter pagamentoAdapter) {
        this.pagamentoAdapter = pagamentoAdapter;
    }

    public void finalizarCompra(double valor) {
        System.out.println("Finalizando compra...");
        pagamentoAdapter.pagar(valor);
        System.out.println("Compra finalizada com sucesso!");
    }
}
