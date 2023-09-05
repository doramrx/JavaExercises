package CarRentalSystem;

public class Tax {
    private static final double TWENTY_PER_CENT = 0.2;
    private static final double FIFTEEN_PER_CENT = 0.15;

    public static double getPercentTax(double basicPayment){
        return basicPayment > 100.0 ? FIFTEEN_PER_CENT : TWENTY_PER_CENT;
    }
}
