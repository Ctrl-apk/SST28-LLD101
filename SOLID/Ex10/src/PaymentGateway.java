public class PaymentGateway implements PaymentGatewayStrategy{
    public String charge(String studentId, double amount) {
        // fake deterministic txn
        return "TXN-9001";
    }
}
