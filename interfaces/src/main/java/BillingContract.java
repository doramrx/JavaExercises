import java.time.Duration;

public interface BillingContract {

    double calculateBasicPayment(double price, Duration duration);
}
