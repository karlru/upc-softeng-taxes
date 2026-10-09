import java.util.Map;

public class Person {
    private String licenseNumber;
    private String name;
    private String surname;
    private String address;
    private Map<String, Vehicle> ownedVehicles;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getFullName() {
        return String.format("%s %s", name, surname);
    }

    public void addVehicle(Vehicle vehicle) {
        ownedVehicles.put(vehicle.getPlateNumber(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) throws IllegalArgumentException {
        if (!ownedVehicles.containsKey(vehicle.getPlateNumber())) {
            throw new IllegalArgumentException("The person does not own the specified vehicle");
        }
        ownedVehicles.remove(vehicle.getPlateNumber());
    }

    public double calculateAnnualTaxes() {
        return ownedVehicles.values().stream().mapToDouble(Vehicle::calculateAnnualTaxes).sum();
    }
}
