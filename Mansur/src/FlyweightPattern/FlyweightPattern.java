package FlyweightPattern;
import java.util.HashMap;
import java.util.Random;

// Interface defining the common methods for employees
interface Employee {
    public void assignSkill(String skill);
    public void task();
}

// Concrete implementation of the Employee interface for Developers
class Developer implements Employee {
    private final String JOB;  // Constant representing the job for Developers
    private String skill;       // Variable to store the assigned skill for Developers

    // Constructor initializing the job for Developers
    public Developer() {
        JOB = "Fix the issue";
    }

    // Method to assign a skill to the Developer
    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    // Method to perform the task for Developers
    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}

// Concrete implementation of the Employee interface for Testers
class Tester implements Employee {
    private final String JOB;  // Constant representing the job for Testers
    private String skill;       // Variable to store the assigned skill for Testers

    // Constructor initializing the job for Testers
    public Tester() {
        JOB = "Test the issue";
    }

    // Method to assign a skill to the Tester
    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    // Method to perform the task for Testers
    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
}

// Factory class responsible for creating and managing Employee objects
class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<String, Employee>(); // HashMap to store created Employee objects

    // Method to get an Employee based on the type (Developer or Tester)
    public static Employee getEmployee(String type) {
        Employee p = null;
        if(m.get(type) != null) {  // If an object of the specified type already exists in the HashMap
            p = m.get(type);         // Retrieve and return the existing object
        } else {
            switch(type) {           // If the object of the specified type doesn't exist, create one based on the type
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }

            m.put(type, p);          // Put the newly created object in the HashMap for future reuse
        }
        return p;
    }
}

// Main class demonstrating the Flyweight Pattern
public class FlyweightPattern {
    private static String employeeType[] = {"Developer", "Tester"};  // Array containing employee types
    private static String skills[] = {"Java", "C++", ".Net", "Python"}; // Array containing skills

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee()); // Get an Employee object using the EmployeeFactory
            e.assignSkill(getRandSkill());  // Assign a random skill to the Employee
            e.task();                       // Perform the task for the Employee
        }
    }

    // Method to get a random employee type
    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);
        return employeeType[randInt];
    }

    // Method to get a random skill
    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);
        return skills[randInt];
    }
}

