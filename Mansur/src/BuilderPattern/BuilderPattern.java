package BuilderPattern;

/*
 * The following code demonstrates the Builder Design Pattern, which is used to construct a complex object step by step.
 */

// Class representing the Vehicle with private fields and a private constructor
class Vehicle
{
    private String engine;
    private int wheel;
    private int airbags;

    // Getter methods for retrieving the values of private fields
    public String getEngine()
    {
        return this.engine;
    }

    public int getWheel()
    {
        return this.wheel;
    }

    public int getAirbags()
    {
        return this.airbags;
    }

    // Private constructor that takes a VehicleBuilder to construct the Vehicle
    private Vehicle(VehicleBuilder builder)
    {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Static nested class representing the VehicleBuilder
    public static class VehicleBuilder
    {
        private String engine;
        private int wheel;
        private int airbags;

        // Constructor for VehicleBuilder with required parameters
        public VehicleBuilder(String engine, int wheel)
        {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Method to set optional parameter airbags and return the builder instance
        public VehicleBuilder setAirbags(int airbags)
        {
            this.airbags = airbags;
            return this;
        }

        // Method to build the final Vehicle instance using the VehicleBuilder
        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }
}

// Main class to test the Builder Pattern
public class BuilderPattern
{
    public static void main(String[] args)
    {
        // Creating a car using the VehicleBuilder with specified engine, wheel, and airbags
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        // Creating a bike using the VehicleBuilder with specified engine and wheel (no airbags specified)
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Displaying the details of the car
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        // Displaying the details of the bike
        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags()); // Note: This will display the default value (0) since it wasn't specified for the bike
    }
}
