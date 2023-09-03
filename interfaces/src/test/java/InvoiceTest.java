import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class InvoiceTest {

    Invoice invoice;

    private void setUpHourlyBillingInvoice(double price){
        BillingContract billingContract = new HourlyBilling();
        LocalDateTime pickupDate = LocalDateTime.of(2018, Month.JUNE, 25, 10, 30);
        LocalDateTime returnDate = LocalDateTime.of(2018, Month.JUNE, 25, 14, 40);
        Duration rentDuration = Duration.between(pickupDate, returnDate);
        invoice = new Invoice(billingContract, price, rentDuration);
    }

    private void setUpDailyBillingInvoice(double price){
        BillingContract billingContract = new DailyBilling();
        LocalDateTime pickupDate = LocalDateTime.of(2018, Month.JUNE, 25, 10, 30);
        LocalDateTime returnDate = LocalDateTime.of(2018, Month.JUNE, 27, 14, 40);
        Duration rentDuration = Duration.between(pickupDate, returnDate);
        invoice = new Invoice(billingContract, price, rentDuration);
    }


    @Test
    @DisplayName("Should calculate hourly billing with 15% tax.")
    void testCalculateWhenPaymentIsGreaterThanOneHundredInHourlyBilling() {
        // Arrange
        this.setUpHourlyBillingInvoice(40.0);

        // Act
        double totalPayment = invoice.calculatePayment();

        // Assert
        assertEquals(200.0, invoice.basicPayment);
        assertEquals(30.0, invoice.tax);
        assertEquals(230.0, totalPayment);
    }

    @Test
    @DisplayName("Should calculate hourly billing with 20% tax.")
    void testCalculateWhenPaymentIsLesserThanOneHundredInHourlyBilling() {
        // Arrange
        this.setUpHourlyBillingInvoice(10.0);

        // Act
        double totalPayment = invoice.calculatePayment();

        // Assert
        assertEquals(50.0, invoice.basicPayment);
        assertEquals(10.0, invoice.tax);
        assertEquals(60.0, totalPayment);
    }

    @Test
    @DisplayName("Should calculate daily billing with 15% tax.")
    void testCalculateWhenPaymentIsGreaterThanOneHundredInDailyBilling() {
        // Arrange
        this.setUpDailyBillingInvoice(130.0);

        // Act
        double totalPayment = invoice.calculatePayment();

        // Assert
        assertEquals(390.0, invoice.basicPayment);
        assertEquals(58.5, invoice.tax);
        assertEquals(448.5, totalPayment);
    }

    @Test
    @DisplayName("Should calculate daily billing with 20% tax.")
    void testCalculateWhenPaymentIsLesserThanOneHundredInDailyBilling() {
        // Arrange
        this.setUpDailyBillingInvoice(5.0);

        // Act
        double totalPayment = invoice.calculatePayment();

        // Assert
        assertEquals(15.0, invoice.basicPayment);
        assertEquals(3.0, invoice.tax);
        assertEquals(18.0, totalPayment);
    }

}


