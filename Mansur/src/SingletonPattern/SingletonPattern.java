package SingletonPattern;
// Singleton class with eager initialization
class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {
        // Private constructor to prevent instantiation
    }

    // Method to get the singleton instance
    public static SingletonEager getInstance() {
        return instance;
    }
}

// Singleton class with lazy initialization (not thread-safe)
class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    // Method to get the singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Singleton class with lazy initialization using synchronized method (thread-safe but may cause performance issues)
class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
        // Private constructor to prevent instantiation
    }

    // Method to get the singleton instance with synchronized keyword on the method
    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

// Singleton class with lazy initialization using double-checked locking (thread-safe and efficient)
class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
        // Private constructor to prevent instantiation
    }

    // Method to get the singleton instance with double-checked locking
    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

// Main class demonstrating the Singleton Pattern
public class SingletonPattern {
    public static void main(String[] args) {
        // Create and print a singleton instance using the SingletonSynchronized class
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);

        // Create and print another instance (should be the same instance)
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}
