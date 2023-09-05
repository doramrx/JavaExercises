package CarRentalSystem;

import java.time.Duration;

public class DailyBilling implements BillingContract {

    private static final double ONE_DAY_IN_MINUTES = 1440.0;

    @Override
    public double calculateBasicPayment(double price, Duration duration) {
        int roundedDays = (int) Math.ceil(duration.toMinutes() / ONE_DAY_IN_MINUTES);
        return price * roundedDays;
    }
}
