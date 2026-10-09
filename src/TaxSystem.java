import java.util.HashMap;
import java.util.Map;

public class TaxSystem {
    private final Map<String, Vehicle> vehicles = new HashMap<>();  // Map plate number to vehicle
    private final Map<String, Person> people = new HashMap<>();  // Map license number to person

    // Vehicle-specific methods

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getPlateNumber(), vehicle);
    }

    public Vehicle getVehicle(String plateNumber) {
        return vehicles.get(plateNumber);
    }

    public void editVehicle(String plateNumber, Vehicle modifiedVehicle) throws IllegalArgumentException {
        if (!plateNumber.equalsIgnoreCase(modifiedVehicle.getPlateNumber())) {
            throw new IllegalArgumentException("Vehicle plate number cannot be modified");
        }
        if (!vehicles.containsKey(plateNumber)) {
            throw new IllegalArgumentException("The vehicle does not exist");
        }
        vehicles.put(plateNumber, modifiedVehicle);
    }

    public void deleteVehicle(String plateNumber) {
        vehicles.remove(plateNumber);
    }

    // Person specific methods

    public void addPerson(Person person) {
        people.put(person.getLicenseNumber(), person);
    }

    public Person getPerson(String licenseNumber) {
        return people.get(licenseNumber);
    }

    public void editPerson(String licenseNumber, Person modifiedPerson) throws IllegalArgumentException {
        if (!licenseNumber.equalsIgnoreCase(modifiedPerson.getLicenseNumber())) {
            throw new IllegalArgumentException("Person license number cannot be modified");
        }
        if (!people.containsKey(licenseNumber)) {
            throw new IllegalArgumentException("The person does not exist");
        }
        people.put(licenseNumber, modifiedPerson);
    }

    public void deletePerson(String licenseNumber) {
        people.remove(licenseNumber);
    }

    // General methods
    public void transferVehicle(Person previousOwner, Person newOwner, Vehicle vehicle) {
        previousOwner.removeVehicle(vehicle);
        newOwner.addVehicle(vehicle);
        System.out.printf(
                "Vehicle %s tranferred from %s to %s. Annual taxes: %.2f%n",
                vehicle.getPlateNumber(),
                previousOwner.getLicenseNumber(),
                newOwner.getLicenseNumber(),
                vehicle.calculateAnnualTaxes()
        );
    }

    public void printTaxesByPerson() {
        for (Person person : people.values()) {
            System.out.printf(
                    "Total annual taxes for %s (%s) are %.2f%n",
                    person.getFullName(), person.getLicenseNumber(), person.calculateAnnualTaxes()
            );
        }
    }

    public void printTaxesByVehicle() {
        for (Vehicle vehicle : vehicles.values()) {
            System.out.printf(
                    "Annual taxes for the vehicle %s are %.2f%n",
                    vehicle.getPlateNumber(), vehicle.calculateAnnualTaxes()
            );
        }
    }
}
