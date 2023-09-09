package ContractSystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class ContractServiceTest {

    OnlinePaymentService onlinePaymentService = new PaypalService();

    @Test
    @DisplayName("Should calculate contract installments correctly.")
    void testContractInstallmentsProcessing() {
        // Arrange
        Contract contract = new Contract(
                "5010AP",
                LocalDate.of(2023, Month.SEPTEMBER, 7),
                600.0);
        ContractService contractService = new ContractService(onlinePaymentService);

        // Act
        contractService.processContract(contract, 3);

        // Assert
        assertEquals(LocalDate.of(2023, Month.OCTOBER, 7),
                     contract.getInstallment(0).getDueDate());
        assertEquals(206.04, contract.getInstallment(0).getAmount());
    }
}
