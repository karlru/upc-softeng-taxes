public class Motorcycle extends Vehicle {
    private double engineDisplacement;

    @Override
    double calculateAnnualTaxes() {
        return 0.1 * engineDisplacement;
    }
}
