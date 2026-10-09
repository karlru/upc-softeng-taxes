public abstract class Vehicle {
    private String plateNumber;
    private String maker;
    private String model;

    abstract double calculateAnnualTaxes();

    public String getPlateNumber() {
        return plateNumber;
    }
}
