# Projeto GoF - Adapter em Java

## Padrão escolhido
Adapter.

## Problema proposto
Um sistema de checkout precisa realizar pagamentos usando diferentes gateways, como PayPal, Mercado Pago e Stripe. Cada gateway possui uma API diferente, com métodos e nomes próprios.

Sem o Adapter, o CheckoutService precisaria conhecer diretamente cada API externa, aumentando o acoplamento e dificultando manutenção.

## Solução
Foi criada a interface `PagamentoAdapter`, que padroniza o método `pagar(double valor)`.

Cada API externa possui um adapter específico:

- `PayPalAdapter`
- `MercadoPagoAdapter`
- `StripeAdapter`

Assim, o sistema trabalha apenas com a interface comum, sem depender diretamente das APIs externas.

## Reflexão e anotação própria
Foi criada a anotação `@GatewayAdapter(nome = "...")`.

A classe `GatewayFactory` usa reflexão para ler essa anotação e instanciar o adapter correto.

Isso reduz o acoplamento porque o código cliente não precisa saber qual classe concreta será usada. Ele informa apenas o nome do gateway.

## Como executar

### Requisitos
- Java 17 ou superior
- Maven instalado

### Rodar com PayPal
```bash
mvn compile exec:java
```

### Rodar com Mercado Pago
```bash
mvn compile exec:java -Dexec.args="mercadopago"
```

### Rodar com Stripe
```bash
mvn compile exec:java -Dexec.args="stripe"
```

## Diagrama UML simplificado

```txt
+--------------------+
|  CheckoutService   |
+--------------------+
| - pagamentoAdapter |
+--------------------+
| + finalizarCompra()|
+---------+----------+
          |
          v
+--------------------+
| PagamentoAdapter   | <<interface>>
+--------------------+
| + pagar(valor)     |
+----+----------+----+
     |          |
     |          |
+----v-----+ +--v----------------+
|PayPal    | |MercadoPagoAdapter |
|Adapter   | +-------------------+
+----------+ | + pagar(valor)    |
|+ pagar() | +-------------------+
+----+-----+          |
     |                |
     v                v
+-----------+   +---------------+
| PayPalApi |   | MercadoPagoApi|
+-----------+   +---------------+

+----------------+
| StripeAdapter  |
+----------------+
| + pagar(valor) |
+-------+--------+
        |
        v
+-----------+
| StripeApi |
+-----------+
```
