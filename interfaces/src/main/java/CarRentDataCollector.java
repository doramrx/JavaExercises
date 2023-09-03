import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CarRentDataCollector {
    private final Scanner sc = new Scanner(System.in);
    private final CarRentData carRentData = new CarRentData();

    public void collectCarRentData() {

        System.out.println("Enter rental data");

        System.out.print("Car model: ");
        this.carRentData.carModel = this.sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        this.carRentData.pickupDate = collectLocalDateTime();

        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        this.carRentData.returnDate = collectLocalDateTime();

        System.out.print("Enter price per hour: ");
        this.carRentData.pricePerHour = Double.parseDouble(this.sc.nextLine());

        System.out.print("Enter price per day: ");
        this.carRentData.pricePerDay = Double.parseDouble(this.sc.nextLine());

        this.sc.close();
    }

    private LocalDateTime collectLocalDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = null;
        try {
            String dateTimeString = this.sc.nextLine();
            dateTime = LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Date entered is not in the proper format." );
        }
        return dateTime;
    }

    public CarRentData getCarRentData() {
        return this.carRentData;
    }
}

class CarRentData {
    public String carModel;
    public LocalDateTime pickupDate;
    public LocalDateTime returnDate;
    public Double pricePerHour;
    public Double pricePerDay;

    @Override
    public String toString() {
        return "CarRentData{" +
                "carModel='" + carModel + '\'' +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", pricePerHour=" + pricePerHour +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}

