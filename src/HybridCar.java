public class HybridCar extends Car {
    @Override
    double calculateAnnualTaxes() {
        return 1.2 * getCo2Emissions();
    }
}
