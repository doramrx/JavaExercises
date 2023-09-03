import java.time.Duration;

public class HourlyBilling implements BillingContract {

    private static final double ONE_HOUR_IN_MINUTES = 60.0;

    @Override
    public double calculateBasicPayment(double price, Duration duration) {
        int roundedHours = (int) Math.ceil(duration.toMinutes() / ONE_HOUR_IN_MINUTES);
        return price * roundedHours;
    }
}
