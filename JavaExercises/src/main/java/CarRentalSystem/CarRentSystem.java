package CarRentalSystem;

import java.time.Duration;
import java.util.Locale;

public class CarRentSystem {
    public void init(){
        Locale.setDefault(Locale.US);

        CarRentDataCollector carRentDataCollector = new CarRentDataCollector();
        carRentDataCollector.collectCarRentData();

        CarRentData carRentData = carRentDataCollector.getCarRentData();
        CarRent carRent = new CarRent(carRentData.carModel, carRentData.pickupDate, carRentData.returnDate);

        Duration rentDuration = carRent.calculateRentDuration();
        double roundedRentDurationInHours = Math.ceil(rentDuration.toMinutes() / 60.0);

        if (roundedRentDurationInHours > 12) {
            carRent.setInvoice(new Invoice(
                    new DailyBilling(),
                    carRentData.pricePerDay,
                    rentDuration)
            );
        } else {
            carRent.setInvoice(new Invoice(
                    new HourlyBilling(),
                    carRentData.pricePerHour,
                    rentDuration)
            );
        }

        carRent.generateInvoice();
    }
}
