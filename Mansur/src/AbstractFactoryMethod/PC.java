package AbstractFactoryMethod;

import AbstractFactoryMethod.Computer;

public class PC extends Computer { // first sub класс
    private String ram;
    private String hdd;
    private String cpu; // our variables

    public PC(String ram, String hdd, String cpu){ // инициализация переменных
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
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