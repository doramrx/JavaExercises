package ContractSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Contract {
    private String number;
    private LocalDate date;
    private double value;
    private ArrayList<Installment> installments = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Contract(String number, LocalDate date, double value) {
        this.number = number;
        this.date = date;
        this.value = value;
    }

    public void addInstallment(Installment installment){
        installments.add(installment);
    }

    public Installment getInstallment(int index) { return installments.get(index); }

    public void printInstallments(){
        for(Installment installment : installments){
            System.out.println(installment.getDueDate().format(formatter) + " - " +
                               String.format("%.2f", installment.getAmount()));
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }
}
