package com.example.payments;
public class SafeCashAdapter implements PaymentGateway{
    private final SafeCashClient client;
    public SafeCashAdapter(SafeCashClient client){
        this.client=client;
    }
    public String charge(String customerId,int amountCents) {

        SafeCashPayment payement= client.createPayment(amountCents,customerId);
        return payement.confirm();
    }

}