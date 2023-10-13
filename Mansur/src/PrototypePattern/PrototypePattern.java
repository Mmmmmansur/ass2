package PrototypePattern;
import java.util.ArrayList;
import java.util.List;

// Prototype interface - Cloneable is a marker interface indicating that an object can be cloned
class Vehicle implements Cloneable {
    private List<String> vehicleList;  // List to store vehicle names

    // Default constructor initializing the vehicle list
    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    // Parameterized constructor with a list of vehicles
    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    // Method to insert sample data into the vehicle list
    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    // Getter method to retrieve the vehicle list
    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    // Override the clone method to provide a deep copy of the object
    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

// Main class demonstrating the Prototype Pattern
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create an instance of Vehicle and insert sample data
        Vehicle a = new Vehicle();
        a.insertData();

        // Clone the instance to create a new instance (b)
        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();

        // Modify the cloned list by adding a new vehicle
        list.add("Honda new Amaze");

        // Print the original and cloned lists
        System.out.println("Original List: " + a.getVehicleList());
        System.out.println("Cloned List: " + list);

        // Remove an item from the cloned list and print both lists again
        b.getVehicleList().remove("Audi A4");
        System.out.println("Modified Cloned List: " + list);
        System.out.println("Original List: " + a.getVehicleList());
    }
}
