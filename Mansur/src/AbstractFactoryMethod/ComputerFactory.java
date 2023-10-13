package AbstractFactoryMethod;

public class ComputerFactory { //фабрика для создания обьектов класса
    public static Computer getComputer(ComputerAbstractFactory factory){ //вызывает наш абстрактный класс
        return factory.createComputer();  // вызов метода из абсtract класса
    }
}