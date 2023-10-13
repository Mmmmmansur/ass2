package FacadePattern;

import java.sql.Driver;

/*
 * The following code demonstrates the Facade Design Pattern, which provides a simplified interface to a set of interfaces in a subsystem, making it easier to use.
 */

// Class representing the Firefox browser with methods for getting the driver and generating HTML and JUnit reports
class Firefox
{
    public static Driver getFirefoxDriver()
    {
        return null; // Returns a Firefox driver instance (not implemented)
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

// Class representing the Chrome browser with methods for getting the driver and generating HTML and JUnit reports
class Chrome
{
    public static Driver getChromeDriver()
    {
        return null; // Returns a Chrome driver instance (not implemented)
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// Class representing the facade that simplifies the usage of different browsers and report generation
class WebExplorerHelperFacade
{
    // Method to generate reports for different browsers and report types
    public static void generateReports(String explorer, String report, String test)
    {
        Driver driver = null;
        switch(explorer)
        {
            case "firefox":
                driver = Firefox.getFirefoxDriver(); // Gets a Firefox driver
                switch(report)
                {
                    case "html":
                        Firefox.generateHTMLReport(test, driver); // Generates HTML report for Firefox
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver); // Generates JUnit report for Firefox
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver(); // Gets a Chrome driver
                switch(report)
                {
                    case "html":
                        Chrome.generateHTMLReport(test, driver); // Generates HTML report for Chrome
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver); // Generates JUnit report for Chrome
                        break;
                }
        }
    }
}

// Main class to test the Facade Pattern
public class FacadePattern
{
    public static void main(String[] args)
    {
        String test = "CheckElementPresent";

        WebExplorerHelperFacade.generateReports("firefox", "html", test); // Generating HTML report for Firefox
        WebExplorerHelperFacade.generateReports("firefox", "junit", test); // Generating JUnit report for Firefox
        WebExplorerHelperFacade.generateReports("chrome", "html", test);  // Generating HTML report for Chrome
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);  // Generating JUnit report for Chrome
    }
}

