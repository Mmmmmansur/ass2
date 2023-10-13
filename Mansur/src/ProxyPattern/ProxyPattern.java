package ProxyPattern;
// Interface defining the DatabaseExecuter behavior
interface DatabaseExecuter {
    public void executeDatabase(String query) throws Exception;
}

// Concrete implementation of the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter {
    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}

// Proxy class implementing the DatabaseExecuter interface
class DatabaseExecuterProxy implements DatabaseExecuter {
    boolean ifAdmin;  // Flag to check if the user is an admin
    DatabaseExecuterImpl dbExecuter;  // Instance of the actual DatabaseExecuter

    // Constructor to initialize the proxy with a username and password
    public DatabaseExecuterProxy(String name, String passwd) {
        if (name.equals("Admin") && passwd.equals("Admin@123")) {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (ifAdmin) {
            // If the user is an admin, allow any query
            dbExecuter.executeDatabase(query);
        } else {
            // If the user is not an admin, restrict DELETE queries
            if (query.equals("DELETE")) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                // Allow other queries for non-admin users
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

// Main class demonstrating the Proxy Pattern
public class ProxyPattern {
    public static void main(String[] args) throws Exception {
        // Create a non-admin user proxy and try executing a DELETE query (should throw an exception)
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");

        // Create another non-admin user proxy and try executing a DELETE query (should throw an exception)
        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");

        // Create an admin user proxy and execute a DELETE query (allowed)
        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");
    }
}
