package AbstractFactoryMethod;

public class Server extends Computer { //второй сабкласс
    private String ram;
    private String hdd;
    private String cpu;

    public Server(String ram, String hdd, String cpu){ // конструктор
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override // implemented methods
    public String getRAM() {
        return this.ram;
    }
    @Override
    public String getHDD() {
        return this.hdd;
    }
    @Override
    public String getCPU() {
        return this.cpu;
    }
}