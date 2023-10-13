package ObserverPattern;
import java.util.ArrayList;
import java.util.List;

// Subject interface providing methods for registering, unregistering, and notifying observers
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Concrete implementation of the Subject interface - DeliveryData
class DeliveryData implements Subject {
    private List<Observer> observers;  // List to store registered observers
    private String location;  // Current location data

    // Constructor initializing the list of observers
    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    // Method to register an observer
    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    // Method to unregister an observer
    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    // Method to notify all registered observers
    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    // Method called when the location changes, updating the location and notifying observers
    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    // Method to get a sample location (in this case, a hardcoded location "YPlace")
    public String getLocation() {
        return "YPlace";
    }
}

// Observer interface defining the update method
interface Observer {
    void update(String location);
}

// Concrete implementation of the Observer interface - Seller
class Seller implements Observer {
    private String location;

    // Method to update the location and display a notification at the Seller
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    // Method to display the current location for the Seller
    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Concrete implementation of the Observer interface - User
class User implements Observer {
    private String location;

    // Method to update the location and display a notification at the User
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    // Method to display the current location for the User
    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Concrete implementation of the Observer interface - DeliveryWarehouseCenter
class DeliveryWarehouseCenter implements Observer {
    private String location;

    // Method to update the location and display a notification at the Warehouse
    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    // Method to display the current location for the Warehouse
    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Main class demonstrating the Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Trigger a location change and notify observers
        topic.locationChanged();

        // Unregister one observer (DeliveryWarehouseCenter)
        topic.unregister(obj3);

        // Print a separator for clarity
        System.out.println();

        // Trigger another location change and notify remaining observers
        topic.locationChanged();
    }
}
