import java.time.Duration;
import java.time.LocalDateTime;

public interface RentCalculationContract {

    void calculateCarRentTotal(Duration duration, Double price);

    Double calculateTax(Duration duration, Double price, int roundedTime);
}
