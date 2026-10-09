public class DieselCar extends Car {
    @Override
    double calculateAnnualTaxes() {
        return 1.8 * getCo2Emissions();
    }
}
