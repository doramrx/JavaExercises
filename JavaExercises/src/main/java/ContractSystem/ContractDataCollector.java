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
        this.contractData.number = this.sc.nextLine();

        try {
            System.out.print("Date (dd/MM/yyyy): ");
            String dateTimeString = this.sc.nextLine();
            this.contractData.date = LocalDate.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Date entered is not in the proper format.");
            e.printStackTrace();
        }

        System.out.print("Contract value: ");
        this.contractData.value = Double.parseDouble(this.sc.nextLine());

        System.out.print("Enter the number of installments: ");
        this.contractData.installments = Integer.parseInt(sc.nextLine());

    }

    public ContractData getContractData(){
        return this.contractData;
    }

}

class ContractData {
    public String number;
    public LocalDate date;
    public double value;
    public int installments;
}
