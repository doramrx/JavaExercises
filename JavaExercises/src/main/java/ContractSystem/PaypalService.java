package ContractSystem;

public class PaypalService implements OnlinePaymentService{

    @Override
    public double paymentFee(double amount) {
        return amount * 0.02;
    }

    @Override
    public double interest(double amount, int month) {
        return  amount * ((double) month/100);
    }
}
