adapter_design_pattern

// Реализация интерфейса WebDriver
// Implementation of the WebDriver interface
interface WebDriver
{
    // Метод для получения элемента
    // Method for getting an element
    public void getElement();

    // Метод для выбора элемента
    // Method for selecting an element
    public void selectElement();
}

// Класс ChromeDriver, реализующий интерфейс WebDriver
// ChromeDriver class implementing the WebDriver interface
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

// Класс IEDriver, не реализующий интерфейс WebDriver
// IEDriver class not implementing the WebDriver interface
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

// Класс WebDriverAdapter, адаптирующий IEDriver к интерфейсу WebDriver
// WebDriverAdapter class adapting IEDriver to the WebDriver interface
class WebDriverAdapter implements WebDriver
{
    IEDriver ieDriver;

    // Конструктор, принимающий объект IEDriver
    // Constructor that takes an IEDriver object
    public WebDriverAdapter(IEDriver ieDriver)
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement()
    {
        // Адаптация метода findElement() IEDriver к методу getElement() интерфейса WebDriver
        // Adapting the findElement() method of IEDriver to the getElement() method of the WebDriver interface
        ieDriver.findElement();
    }

    @Override
    public void selectElement()
    {
        // Адаптация метода clickElement() IEDriver к методу selectElement() интерфейса WebDriver
        // Adapting the clickElement() method of IEDriver to the selectElement() method of the WebDriver interface
        ieDriver.clickElement();
    }
}

// Главный класс для демонстрации паттерна "Адаптер"
// Main class to demonstrate the Adapter pattern
public class AdapterPattern
{
    public static void main(String[] args)
    {
        // Создаем объект ChromeDriver
        // Create a ChromeDriver object
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        // Создаем объект IEDriver
        // Create an IEDriver object
        IEDriver ieDriver = new IEDriver();
        ieDriver.findElement();
        ieDriver.clickElement();

        // Создаем адаптер, чтобы использовать IEDriver как объект WebDriver
        // Create an adapter to use IEDriver as a WebDriver object
        WebDriver webDriverAdapter = new WebDriverAdapter(ieDriver);
        webDriverAdapter.getElement();
        webDriverAdapter.selectElement();
    }
}


bridge_design_pattern

// Абстрактный класс TV
// Abstract class TV
abstract class TV
{
    Remote remote;
    TV(Remote r)
    {
        this.remote = r;
    }
    abstract void on();
    abstract void off();
}

// Класс Sony, наследующий от TV
// Sony class inheriting from TV
class Sony extends TV
{
    Remote remoteType;
    Sony(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off()
    {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Класс Philips, наследующий от TV
// Philips class inheriting from TV
class Philips extends TV
{
    Remote remoteType;
    Philips(Remote r)
    {
        super(r);
        this.remoteType = r;
    }

    public void on()
    {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public off()
    {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Интерфейс Remote
// Remote interface
interface Remote
{
    public void on();
    public void off();
}

// Класс OldRemote, реализующий интерфейс Remote
// OldRemote class implementing the Remote interface
class OldRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with Old Remote");
    }
}

// Класс NewRemote, реализующий интерфейс Remote
// NewRemote class implementing the Remote interface
class NewRemote implements Remote
{
    @Override
    public void on()
    {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off()
    {
        System.out.println("OFF with New Remote");
    }
}

// Главный класс для демонстрации паттерна "Мост"
// Main class to demonstrate the Bridge pattern
public class BridgePattern
{
    public static void main(String[] args)
    {
        // Создаем объект Sony с использованием старого пульта (OldRemote)
        // Create a Sony object using the old remote (OldRemote)
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        // Создаем объект Sony с использованием нового пульта (NewRemote)
        // Create a Sony object using the new remote (NewRemote)
        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        // Создаем объект Philips с использованием старого пульта (OldRemote)
        // Create a Philips object using the old remote (OldRemote)
        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        // Создаем объект Philips с использованием нового пульта (NewRemote)
        // Create a Philips object using the new remote (NewRemote)
        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}

builder_design_pattern

// Класс Vehicle (Транспортное средство)
// Class Vehicle
class Vehicle
{
    private String engine;  // Тип двигателя
    private int wheel;      // Количество колес
    private int airbags;    // Количество подушек безопасности

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

    // Приватный конструктор класса Vehicle
    // Private constructor of the Vehicle class
    private Vehicle(VehicleBuilder builder)
    {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Вложенный класс VehicleBuilder (Строитель Транспортного средства)
    // Nested class VehicleBuilder
    public static class VehicleBuilder
    {
        private String engine;   // Тип двигателя
        private int wheel;       // Количество колес
        private int airbags;     // Количество подушек безопасности

        // Конструктор класса VehicleBuilder
        // Constructor of the VehicleBuilder class
        public VehicleBuilder(String engine, int wheel)
        {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Метод для установки количества подушек безопасности
        // Method to set the number of airbags
        public VehicleBuilder setAirbags(int airbags)
        {
            this.airbags = airbags;
            return this;
        }

        // Метод для построения объекта Vehicle
        // Method to build a Vehicle object
        public Vehicle build()
        {
            return new Vehicle(this);
        }
    }
}

// Главный класс для демонстрации паттерна "Строитель"
// Main class to demonstrate the Builder pattern
public class BuilderPattern
{
    public static void main(String[] args)
    {
        // Создаем объект car (автомобиль) с использованием строителя VehicleBuilder
        // Create a car object using the VehicleBuilder
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();

        // Создаем объект bike (мотоцикл) с использованием строителя VehicleBuilder
        // Create a bike object using the VehicleBuilder
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Выводим информацию о параметрах автомобиля (car)
        // Print information about the car
        System.out.println("Двигатель автомобиля (Engine of car): " + car.getEngine());
        System.out.println("Количество колес автомобиля (Wheels of car): " + car.getWheel());
        System.out.println("Количество подушек безопасности автомобиля (Airbags of car): " + car.getAirbags());

        // Выводим информацию о параметрах мотоцикла (bike)
        // Print information about the bike
        System.out.println("Двигатель мотоцикла (Engine of bike): " + bike.getEngine());
        System.out.println("Количество колес мотоцикла (Wheels of bike): " + bike.getWheel());
        System.out.println("Количество подушек безопасности мотоцикла (Airbags of bike): " + bike.getAirbags());
    }
}

composite_design_pattern

// Абстрактный класс Account (Счет)
// Abstract class Account
abstract class Account
{
    public abstract float getBalance(); // Абстрактный метод для получения баланса
}

// Класс DepositeAccount (Депозитный счет), наследующий от Account
// DepositeAccount class inheriting from Account
class DepositeAccount extends Account
{
    private String accountNo; // Номер счета
    private float accountBalance; // Баланс счета

    public DepositeAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance()
    {
        return accountBalance;
    }
}

// Класс SavingAccount (Сберегательный счет), наследующий от Account
// SavingAccount class inheriting from Account
class SavingAccount extends Account
{
    private String accountNo; // Номер счета
    private float accountBalance; // Баланс счета

    public SavingAccount(String accountNo, float accountBalance)
    {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance()
    {
        return accountBalance;
    }
}

// Класс CompositeAccount (Составной счет), наследующий от Account
// CompositeAccount class inheriting from Account
class CompositeAccount extends Account
{
    private float totalBalance; // Общий баланс
    private List<Account> accountList = new ArrayList<Account>(); // Список подсчетов, входящих в состав

    public float getBalance()
    {
        totalBalance = 0;
        for (Account account : accountList)
        {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account)
    {
        accountList.add(account);
    }

    public void removeAccount(Account account)
    {
        accountList.remove(account);
    }
}

// Главный класс для демонстрации паттерна "Компоновщик"
// Main class to demonstrate the Composite pattern
public class CompositePattern
{
    public static void main(String[] args)
    {
        CompositeAccount composite = new CompositeAccount();

        composite.addAccount(new DepositeAccount("DA001", 100));
        composite.addAccount(new DepositeAccount("DA002", 150));
        composite.addAccount(new SavingAccount("SA001", 200));

        float totalBalance = composite.getBalance();
        System.out.println("Общий баланс (Total Balance) : " + totalBalance);
    }
}

decorator_design_pattern

// Интерфейс Dress (Одежда)
// Interface Dress
interface Dress
{
    public void assemble();
}

// Класс BasicDress (Базовая одежда), реализующий интерфейс Dress
// BasicDress class implementing the Dress interface
class BasicDress implements Dress
{
    @Override
    public void assemble()
    {
        System.out.println("Basic Dress Features"); // Основные характеристики одежды
    }
}

// Класс DressDecorator (Декоратор одежды), реализующий интерфейс Dress
// DressDecorator class implementing the Dress interface
class DressDecorator implements Dress
{
    protected Dress dress;
    public DressDecorator(Dress c)
    {
        this.dress = c;
    }

    @Override
    public void assemble()
    {
        this.dress.assemble();
    }
}

// Класс CasualDress (Повседневная одежда), расширяющий DressDecorator
// CasualDress class extending DressDecorator
class CasualDress extends DressDecorator
{
    public CasualDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Casual Dress Features"); // Добавление характеристик повседневной одежды
    }
}

// Класс SportyDress (Спортивная одежда), расширяющий DressDecorator
// SportyDress class extending DressDecorator
class SportyDress extends DressDecorator
{
    public SportyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Sporty Dress Features"); // Добавление характеристик спортивной одежды
    }
}

// Класс FancyDress (Праздничная одежда), расширяющий DressDecorator
// FancyDress class extending DressDecorator
class FancyDress extends DressDecorator
{
    public FancyDress(Dress c)
    {
        super(c);
    }

    @Override
    public void assemble()
    {
        super.assemble();
        System.out.println("Adding Fancy Dress Features"); // Добавление характеристик праздничной одежды
    }
}

// Главный класс для демонстрации паттерна "Декоратор"
// Main class to demonstrate the Decorator pattern
public class DecoratorPattern
{
    public static void main(String[] args)
    {
        Dress sportyDress = new SportyDress(new BasicDress()); // Создаем спортивную одежду, оборачивая базовую одежду
        sportyDress.assemble(); // Выводим информацию о спортивной одежде
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress()); // Создаем праздничную одежду, оборачивая базовую одежду
        fancyDress.assemble(); // Выводим информацию о праздничной одежде
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress()); // Создаем повседневную одежду, оборачивая базовую одежду
        casualDress.assemble(); // Выводим информацию о повседневной одежде
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress())); // Создаем спортивную праздничную одежду
        sportyFancyDress.assemble(); // Выводим информацию о спортивной праздничной одежде
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress())); // Создаем повседневную праздничную одежду
        casualFancyDress.assemble(); // Выводим информацию о повседневной праздничной одежде
    }
}

facade_design_pattern

// Класс Firefox
// Firefox class
class Firefox
{
    public static Driver getFirefoxDriver()
    {
        return null; // Здесь обычно создается и возвращается драйвер Firefox
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

// Класс Chrome
// Chrome class
class Chrome
{
    public static Driver getChromeDriver()
    {
        return null; // Здесь обычно создается и возвращается драйвер Chrome
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

// Класс WebExplorerHelperFacade (Фасад для веб-браузеров)
// WebExplorerHelperFacade class (Facade for web browsers)
class WebExplorerHelperFacade
{
    public static void generateReports(String explorer, String report, String test)
    {
        Driver driver = null;
        switch(explorer)
        {
            case "firefox":
                driver = Firefox.getFirefoxDriver(); // Получаем драйвер Firefox
                switch(report)
                {
                    case "html":
                        Firefox.generateHTMLReport(test, driver); // Генерируем HTML-отчет
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver); // Генерируем JUnit-отчет
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver(); // Получаем драйвер Chrome
                switch(report)
                {
                    case "html":
                        Chrome.generateHTMLReport(test, driver); // Генерируем HTML-отчет
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver); // Генерируем JUnit-отчет
                        break;
                }
        }
    }
}

// Главный класс для демонстрации паттерна "Фасад"
// Main class to demonstrate the Facade pattern
public class FacadePattern
{
    public static void main(String[] args)
    {
        String test = "CheckElementPresent";

        WebExplorerHelperFacade.generateReports("firefox", "html", test); // Генерация HTML-отчета для Firefox
        WebExplorerHelperFacade.generateReports("firefox", "junit", test); // Генерация JUnit-отчета для Firefox
        WebExplorerHelperFacade.generateReports("chrome", "html", test); // Генерация HTML-отчета для Chrome
        WebExplorerHelperFacade.generateReports("chrome", "junit", test); // Генерация JUnit-отчета для Chrome
    }
}


factory_design_pattern

// Абстрактный класс Vehicle (Транспортное средство)
// Abstract class Vehicle
abstract class Vehicle
{
    public abstract int getWheel(); // Абстрактный метод для получения количества колес
    public String toString()
    {
        return "Wheel: " + this.getWheel();
    }
}

// Класс Car (Автомобиль), наследующий от Vehicle
// Car class inheriting from Vehicle
class Car extends Vehicle
{
    int wheel;
    Car(int wheel)
    {
        this.wheel = wheel;
    }

    @Override
    public int getWheel()
    {
        return this.wheel;
    }
}

// Класс Bike (Велосипед), наследующий от Vehicle
// Bike class inheriting from Vehicle
class Bike extends Vehicle
{
    int wheel;
    Bike(int wheel)
    {
        this.wheel = wheel;
    }

    @Override
    public int getWheel()
    {
        return this.wheel;
    }
}

// Класс VehicleFactory (Фабрика транспортных средств)
// VehicleFactory class
class VehicleFactory
{
    public static Vehicle getInstance(String type, int wheel)
    {
        if(type.equals("car"))
        {
            return new Car(wheel); // Создаем и возвращаем объект класса Car
        }
        else if(type.equals("bike"))
        {
            return new Bike(wheel); // Создаем и возвращаем объект класса Bike
        }
        return null;
    }
}

// Главный класс для демонстрации паттерна "Фабрика"
// Main class to demonstrate the Factory pattern
public class FactoryPattern
{
    public static void main(String[] args)
    {
        Vehicle car = VehicleFactory.getInstance("car", 4); // Создаем объект типа "автомобиль" с 4 колесами
        System.out.println(car); // Выводим информацию о транспортном средстве (автомобиле)

        Vehicle bike = VehicleFactory.getInstance("bike", 2); // Создаем объект типа "велосипед" с 2 колесами
        System.out.println(bike); // Выводим информацию о транспортном средстве (велосипеде)
    }
}

flyweight_design_pattern

// Интерфейс Employee (Сотрудник)
// Employee interface
interface Employee
{
    public void assignSkill(String skill); // Метод для назначения навыка
    public void task(); // Метод для выполнения задачи
}

// Класс Developer (Разработчик), реализующий интерфейс Employee
// Developer class implementing the Employee interface
class Developer implements Employee
{
    private final String JOB;
    private String skill;

    public Developer()
    {
        JOB = "Fix the issue"; // Задача разработчика
    }

    @Override
    public void assignSkill(String skill)
    {
        this.skill = skill;
    }

    @Override
    public void task()
    {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}

// Класс Tester (Тестировщик), реализующий интерфейс Employee
// Tester class implementing the Employee interface
class Tester implements Employee
{
    private final String JOB;
    private String skill;

    public Tester()
    {
        JOB = "Test the issue"; // Задача тестировщика
    }

    @Override
    public void assignSkill(String skill)
    {
        this.skill = skill;
    }

    @Override
    public void task()
    {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
}

// Класс EmployeeFactory (Фабрика сотрудников)
// EmployeeFactory class
class EmployeeFactory
{
    private static HashMap<String, Employee> m = new HashMap<String, Employee>();

    public static Employee getEmployee(String type)
    {
        Employee p = null;
        if (m.get(type) != null)
        {
            p = m.get(type);
        }
        else
        {
            switch (type)
            {
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

            m.put(type, p);
        }
        return p;
    }
}

// Главный класс для демонстрации паттерна "Легковес"
// Main class to demonstrate the Flyweight pattern
public class FlyweightPattern
{
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            e.assignSkill(getRandSkill());
            e.task();
        }
    }

    public static String getRandEmployee()
    {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);
        return employeeType[randInt];
    }

    public static String getRandSkill()
    {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);
        return skills[randInt];
    }
}

observer_design_pattern

// Интерфейс Subject (Субъект)
// Subject interface
interface Subject
{
    void register(Observer obj); // Метод для регистрации наблюдателя
    void unregister(Observer obj); // Метод для отмены регистрации наблюдателя
    void notifyObservers(); // Метод для уведомления наблюдателей
}

// Класс DeliveryData (Данные о доставке), реализующий интерфейс Subject
// DeliveryData class implementing the Subject interface
class DeliveryData implements Subject
{
    private List<Observer> observers;
    private String location;

    public DeliveryData()
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj)
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
        for (Observer obj : observers)
        {
            obj.update(location);
        }
    }

    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation()
    {
        return "YPlace";
    }
}

// Интерфейс Observer (Наблюдатель)
// Observer interface
interface Observer
{
    public void update(String location); // Метод для обновления состояния наблюдателя
}

// Класс Seller (Продавец), реализующий интерфейс Observer
// Seller class implementing the Observer interface
class Seller implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Класс User (Пользователь), реализующий интерфейс Observer
// User class implementing the Observer interface
class User implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Класс DeliveryWarehouseCenter (Центр доставки), реализующий интерфейс Observer
// DeliveryWarehouseCenter class implementing the Observer interface
class DeliveryWarehouseCenter implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

// Главный класс для демонстрации паттерна "Наблюдатель"
// Main class to demonstrate the Observer pattern
public class ObserverPattern
{
    public static void main(String[] args)
    {
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        topic.locationChanged();
        topic.unregister(obj3);

        System.out.println();
        topic.locationChanged();
    }
}

prototype_design_pattern

// Класс Vehicle (Транспортное средство) реализует интерфейс Cloneable
// Vehicle class implements the Cloneable interface
class Vehicle implements Cloneable
{
    private List<String> vehicleList;

    public Vehicle()
    {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list)
    {
        this.vehicleList = list;
    }

    // Метод для добавления данных о транспортных средствах
    // Method to insert vehicle data
    public void insertData()
    {
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    // Метод для получения списка транспортных средств
    // Method to get the list of vehicles
    public List<String> getVehicleList()
    {
        return this.vehicleList;
    }

    // Переопределенный метод clone() для создания копии объекта
    // Overridden clone() method for creating a copy of the object
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList())
        {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypePattern
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone(); // Создаем копию объекта a
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze"); // Добавляем новое транспортное средство в список

        System.out.println(a.getVehicleList()); // Выводим список транспортных средств из объекта a
        System.out.println(list); // Выводим список транспортных средств из объекта b

        b.getVehicleList().remove("Audi A4"); // Удаляем транспортное средство из списка b
        System.out.println(list); // Выводим измененный список из объекта b
        System.out.println(a.getVehicleList()); // Выводим список из объекта a (не изменен)
    }
}

proxy_design_pattern

// Интерфейс DatabaseExecuter (Исполнитель базы данных)
// DatabaseExecuter interface
interface DatabaseExecuter
{
    public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl (Реализация исполнителя базы данных) реализует интерфейс DatabaseExecuter
// DatabaseExecuterImpl class implements the DatabaseExecuter interface
class DatabaseExecuterImpl implements DatabaseExecuter
{
    @Override
    public void executeDatabase(String query) throws Exception
    {
        System.out.println("Going to execute Query: " + query);
    }
}

// Класс DatabaseExecuterProxy (Прокси исполнителя базы данных) реализует интерфейс DatabaseExecuter
// DatabaseExecuterProxy class implements the DatabaseExecuter interface
class DatabaseExecuterProxy implements DatabaseExecuter
{
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String name, String passwd)
    {
        if(name == "Admin" && passwd == "Admin@123")
        {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception
    {
        if(ifAdmin)
        {
            dbExecuter.executeDatabase(query);
        }
        else
        {
            if(query.equals("DELETE"))
            {
                throw new Exception("DELETE not allowed for non-admin user");
            }
            else
            {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}

// Главный класс для демонстрации паттерна "Прокси"
// Main class to demonstrate the Proxy pattern
public class ProxyPattern
{
    public static void main(String[] args) throws Exception
    {
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE"); // Попытка выполнения запроса DELETE не-администратором

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE"); // Попыт

singleton_design_pattern

// Реализация Singleton с ленивой инициализацией (Eager Initialization)
// Singleton with Eager Initialization
        class SingletonEager
        {
            private static SingletonEager instance = new SingletonEager(); // Создаем экземпляр в момент загрузки класса
            private SingletonEager()
            {

            }
            public static SingletonEager getInstance()
            {
                return instance; // Возвращает заранее созданный экземпляр
            }
        }

// Реализация Singleton с ленивой инициализацией (Lazy Initialization)
// Singleton with Lazy Initialization
        class Singleton
        {
            private static Singleton instance;
            private Singleton()
            {

            }
            public static Singleton getInstance()
            {
                if(instance == null) // Создаем экземпляр только при первом вызове
                {
                    instance = new Singleton();
                }
                return instance; // Возвращает существующий экземпляр
            }
        }

// Реализация Singleton с ленивой инициализацией и синхронизацией метода (Lazy Initialization with Method Synchronization)
        class SingletonSynchronizedMethod
        {
            private static SingletonSynchronizedMethod instance;
            private SingletonSynchronizedMethod()
            {

            }
            public static synchronized SingletonSynchronizedMethod getInstance()
            {
                if(instance == null)
                {
                    instance = new SingletonSynchronizedMethod();
                }
                return instance;
            }
        }

// Реализация Singleton с ленивой инициализацией и двойной проверкой синхронизации (Lazy Initialization with Double-Checked Locking)
        class SingletonSynchronized
        {
            private static SingletonSynchronized instance;
            private SingletonSynchronized()
            {

            }
            public static SingletonSynchronized getInstance()
            {
                if(instance == null)
                {
                    synchronized (SingletonSynchronized.class)
                    {
                        if(instance == null)
                        {
                            instance = new SingletonSynchronized();
                        }
                    }
                }
                return instance;
            }
        }

// Главный класс для демонстрации различных реализаций Singleton
// Main class to demonstrate different Singleton implementations
        public class SingletonPattern
        {
            public static void main(String[] args)
            {
                SingletonSynchronized instance = SingletonSynchronized.getInstance();
                System.out.println(instance); // Выводим экземпляр Singleton
                SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
                System.out.println(instance1); // Выводим ещё один экземпляр Singleton, который должен быть тем же самым
            }
        }