package CarRentalSystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class CarRentTest {

    Invoice invoiceMock;
    CarRent carRent;

    @Test
    @DisplayName("Should calculate rent duration correctly.")
    void testCalculateRentDuration(){
        //Arrange
        LocalDateTime pickupDate = LocalDateTime.of(2018, Month.JUNE, 25, 10, 30);
        LocalDateTime returnDate = LocalDateTime.of(2018, Month.JUNE, 25, 14, 40);
        carRent = new CarRent(null, pickupDate, returnDate);

        //Act
        Duration rentDuration = carRent.calculateRentDuration();

        //Assert
        assertEquals(250, rentDuration.toMinutes());
    }

    @Test
    @DisplayName("Should call 2 invoice's methods.")
    void testPrintInvoice(){
        //Arrange
        carRent = new CarRent(null, null, null);

        this.invoiceMock = mock(Invoice.class);
        carRent.setInvoice(this.invoiceMock);

        //Act
        carRent.generateInvoice();

        //Assert
        verify(this.invoiceMock, atMostOnce()).calculatePayment();
        verify(this.invoiceMock, atMostOnce()).printInvoice();
    }
}
