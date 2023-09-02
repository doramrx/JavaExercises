import java.time.Duration;
import java.time.LocalDateTime;

public class CarRentPerHour extends CarRent{

    public CarRentPerHour(String carModel, LocalDateTime pickupDate, LocalDateTime returnDate, Double pricePerHour) {
        super(carModel, pickupDate, returnDate, pricePerHour);
    }

    @Override
    public void calculateCarRentTotal(Duration duration, Double price) {
        int roundedHours = (int) Math.ceil(duration.toMinutes()/60.0);
        double tax = calculateTax(duration, price, roundedHours);

        super.printInvoice(price, tax, roundedHours);
    }

    @Override
    public Double calculateTax(Duration duration, Double price, int roundedHours) {
        double tax = 0.0;
        double basicPayment = price * roundedHours;

        tax = basicPayment * 0.2;

        return tax;
    }
}
