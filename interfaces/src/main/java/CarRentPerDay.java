import java.time.Duration;
import java.time.LocalDateTime;

public class CarRentPerDay extends CarRent{

    public CarRentPerDay(String carModel, LocalDateTime pickupDate, LocalDateTime returnDate, Double pricePerDay) {
        super(carModel, pickupDate, returnDate, pricePerDay);
    }

    @Override
    public void calculateCarRentTotal(Duration duration, Double price) {
        int roundedDays = (int) Math.ceil(duration.toMinutes()/1440.0);
        double tax = calculateTax(duration, price, roundedDays);

        super.printInvoice(price, tax, roundedDays);
    }

    @Override
    public Double calculateTax(Duration duration, Double price, int roundedDays) {
        double tax = 0.0;
        double basicPayment = price * roundedDays;

        tax = basicPayment * 0.15;

        return tax;
    }
}
