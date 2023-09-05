package ContractSystem;

import java.time.LocalDate;

public class ContractService {

    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract (Contract contract, int months){
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double amount = contract.getValue();
            double installment = amount / months;
            installment += onlinePaymentService.interest(installment, i);
            installment += onlinePaymentService.paymentFee(installment);

            Installment installmentObj = new Installment(dueDate, installment);
            contract.addInstallment(installmentObj);
        }
    }
}
