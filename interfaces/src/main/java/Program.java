import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");

        System.out.print("Car model: ");
        String carModel = sc.nextLine();

        LocalDateTime pickupDate = LocalDateTime.now();
        LocalDateTime returnDate = LocalDateTime.now();

        try{
            System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
            String pickupString = sc.nextLine();
            pickupDate = LocalDateTime.parse(pickupString, formatter);

            System.out.print("Return (dd/MM/yyyy hh:ss): ");
            String returnString = sc.nextLine();
            returnDate = LocalDateTime.parse(returnString, formatter);
        } catch (DateTimeParseException e){
            System.out.println("Date entered is not in the proper format." );
            e.printStackTrace();
        }

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        Duration duration = Duration.between(pickupDate, returnDate);

        CarRent carRent;

        if(duration.toHours() > 12){
            carRent = new CarRentPerDay(carModel, pickupDate, returnDate, pricePerDay);
            carRent.calculateCarRentTotal(duration, pricePerDay);
        }else{
            carRent = new CarRentPerHour(carModel, pickupDate, returnDate, pricePerHour);
            carRent.calculateCarRentTotal(duration, pricePerHour);
        }

        sc.close();

    }
}
