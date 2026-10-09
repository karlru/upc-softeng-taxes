public class PetrolCar extends Car {
    @Override
    double calculateAnnualTaxes() {
        return 1.4 * getCo2Emissions();
    }
}
