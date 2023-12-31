package ContractSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ContractDataCollector {
    private final Scanner sc = new Scanner(System.in);
    private final ContractData contractData = new ContractData();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void collectContractData(){
        System.out.println("Enter Contract data: ");

        System.out.print("Number: ");
        this.collectContractNumber();

        System.out.print("Date (dd/MM/yyyy): ");
        this.collectContractDate();

        System.out.print("Contract value: ");
        this.collectContractValue();

        System.out.print("Enter the number of installments: ");
        this.collectContractInstallments();

    }

    public ContractData getContractData(){
        return this.contractData;
    }

    private void collectContractNumber(){
        String contractNumber = this.sc.nextLine();
        if (contractNumber.trim().isEmpty()) {
            System.out.println("Contract number must be informed.");

            do {
                System.out.print("Enter a valid contract number: ");
                contractNumber = this.sc.nextLine();
            } while (contractNumber.trim().isEmpty());

        }
        this.contractData.number = contractNumber;
    }

    private void collectContractDate(){
        boolean validDate = false;
        while (!validDate){
            String dateTimeString = this.sc.nextLine();
            try {
                this.contractData.date = LocalDate.parse(dateTimeString, formatter);
                validDate = true;
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format. Please enter a valid date in dd/MM/yyyy format: ");
            }
        }
    }

    private void collectContractValue(){
        double contractValue = Double.parseDouble(this.sc.nextLine());
        if (contractValue <= 0) {
            System.out.println("Contract value must be greater than 0.");

            do {
                System.out.print("Enter a valid contract value: ");
                contractValue = Double.parseDouble(this.sc.nextLine());
            } while (contractValue <= 0);

        }
        this.contractData.value = contractValue;
    }

    private void collectContractInstallments(){
        int installmentsValue = Integer.parseInt(this.sc.nextLine());
        if (installmentsValue <= 0) {
            System.out.println("Installments number must be greater than 0.");

            do {
                System.out.print("Enter a valid installments number: ");
                installmentsValue = Integer.parseInt(this.sc.nextLine());
            } while (installmentsValue <= 0);

        }
        this.contractData.installments = installmentsValue;
    }
}

class ContractData {
    public String number;
    public LocalDate date;
    public double value;
    public int installments;
}