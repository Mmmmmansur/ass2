package FactoryMethod;

public class TestFactory {
    public static void main(String[] args) { // класс, где запускается наша программа
        Computer pc = ComputerFactory.getComputer("pc", "2 GB", "500GB", "2.4 GHz"); // вызывает метод с нашей фабрики и запускает метод getComputer
        Computer server = ComputerFactory.getComputer("server", "16 GB", "1 TB", "2.9 GHz");
        System.out.println("Factory PC Config::" + pc); // вывод на консоль
        System.out.println("Factory Server Config::" + server);
    }
}