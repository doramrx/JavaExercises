package ContractSystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    public Installment getInstallment(int index){
        return installments.get(index);
    }

    public void printInstallments(){
        for(Installment installment : installments){
            System.out.println(installment.getDueDate().format(formatter) + " - " +
                               String.format("%.2f", installment.getAmount()));
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
