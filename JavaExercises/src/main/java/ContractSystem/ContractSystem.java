package ContractSystem;

import java.util.Locale;
import java.util.Scanner;

public class ContractSystem {
    public void init(){
        Locale.setDefault(Locale.US);
        final Scanner sc = new Scanner(System.in);

        ContractDataCollector contractDataCollector = new ContractDataCollector();
        contractDataCollector.collectContractData();

        ContractData contractData = contractDataCollector.getContractData();
        Contract contract = new Contract(contractData.number, contractData.date, contractData.value);

        System.out.print("Enter the number of installments: ");
        int installments = Integer.parseInt(sc.nextLine());

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, installments);

        System.out.println("Installments: ");
        contract.printInstallments();
    }
}
