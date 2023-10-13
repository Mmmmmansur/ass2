package AbstractFactoryMethod;

public class PCFactory implements ComputerAbstractFactory { // Фактори классы для каждого подкласса
    private String ram;
    private String hdd;
    private String cpu;

    public PCFactory(String ram, String hdd, String cpu){ //конструктор
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public Computer createComputer() { // method implementation
        return new PC(ram,hdd,cpu);
    }
}