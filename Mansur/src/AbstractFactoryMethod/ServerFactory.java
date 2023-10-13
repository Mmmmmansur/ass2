package AbstractFactoryMethod;

public class ServerFactory implements ComputerAbstractFactory { // Фактори классы для каждого подкласса
    private String ram;
    private String hdd;
    private String cpu;

    public ServerFactory(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }

    @Override
    public Computer createComputer() { // method implementation
        return new Server(ram,hdd,cpu);
    }
}