package AdapterPattern;
// Define the common interface for different web drivers
interface WebDriver
{
    public void getElement();
    public void selectElement();
}

// Implement the ChromeDriver class that adheres to the WebDriver interface
class ChromeDriver implements WebDriver
{
    @Override
    public void getElement()
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement()
    {
        System.out.println("Select element from ChromeDriver");
    }
}

// IEDriver class with specific methods
class IEDriver
{
    public void findElement()
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }
}

// Adapter class to make IEDriver compatible with the WebDriver interface
class WebDriverAdapter implements WebDriver
{
    IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver)
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement()
    {
        ieDriver.findElement();
    }

    @Override
    public void selectElement()
    {
        ieDriver.clickElement();
    }
}

// Main class to test the Adapter Pattern
public class AdapterPattern
{
    public static void main(String[] args)
    {
        // Test ChromeDriver
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        // Test IEDriver
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        // Use the adapter to make IEDriver compatible with WebDriver interface
        WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();
    }
}
