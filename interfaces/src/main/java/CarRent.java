import java.time.Duration;
import java.time.LocalDateTime;

public class CarRent implements RentCalculationContract{
    private String carModel;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private Double price;


    public CarRent(String carModel, LocalDateTime pickupDate, LocalDateTime returnDate, Double price) {
        this.carModel = carModel;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarRent {" +
                "\ncarModel = '" + carModel + '\'' +
                "\npickupDate = " + pickupDate +
                "\nreturnDate = " + returnDate +
                "\nprice = " + price +
                '}';
    }

    @Override
    public void calculateCarRentTotal(Duration duration, Double price) {}

    @Override
    public Double calculateTax(Duration duration, Double price, int roundedTime) {
        return null;
    }

    public void printInvoice(Double price, Double tax, int roundedTime){
        double basicPayment = price * roundedTime;
        double totalPayment = basicPayment + tax;

        System.out.println("\nINVOICE");
        System.out.println("Basic payment: " + String.format("%.2f", basicPayment));
        System.out.println("Tax: " + String.format("%.2f", tax));
        System.out.println("Total payment: " + String.format("%.2f", totalPayment));
    }

}
