package ContractSystem;
import java.util.Locale;

public class ContractSystem {
    public void init(){
        Locale.setDefault(Locale.US);

        ContractDataCollector contractDataCollector = new ContractDataCollector();
        contractDataCollector.collectContractData();

        ContractData contractData = contractDataCollector.getContractData();
        Contract contract = new Contract(contractData.number, contractData.date, contractData.value);

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, contractData.installments);

        contract.printInstallments();
    }
}
