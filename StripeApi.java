package br.com.projeto.legado;

public class StripeApi {

    public void charge(double amount) {
        System.out.println("Pagamento de R$ " + amount + " realizado via Stripe.");
    }
}
