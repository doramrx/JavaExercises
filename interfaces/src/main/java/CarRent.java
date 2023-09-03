import java.time.Duration;
import java.time.LocalDateTime;

public class CarRent{
    private String carModel;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private Invoice invoice;

    public CarRent(String carModel, LocalDateTime pickupDate, LocalDateTime returnDate) {
        this.carModel = carModel;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Duration calculateRentDuration(){
        return Duration.between(this.pickupDate, this.returnDate);
    }

    public void generateInvoice(){
        invoice.calculatePayment();
        invoice.printInvoice();
    }
}
