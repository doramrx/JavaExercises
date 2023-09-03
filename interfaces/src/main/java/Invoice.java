import java.time.Duration;

public class Invoice {
    private BillingContract billingContract;
    private double price;
    private Duration rentDuration;
    protected double basicPayment;
    protected double tax;

    public Invoice(BillingContract billingContract, double price, Duration rentDuration) {
        this.billingContract = billingContract;
        this.price = price;
        this.rentDuration = rentDuration;
    }

    public double calculatePayment(){
        this.basicPayment = this.billingContract.calculateBasicPayment(
                this.price,
                this.rentDuration
        );

        this.tax = Tax.getPercentTax(this.basicPayment) * basicPayment;

        return this.basicPayment + this.tax;
    }

    public void printInvoice(){
        double totalPayment = calculatePayment();

        System.out.println("\nINVOICE");
        System.out.println("Basic payment: " + String.format("%.2f", this.basicPayment));
        System.out.println("Tax: " + String.format("%.2f", this.tax));
        System.out.println("Total payment: " + String.format("%.2f", totalPayment));
    }
}
