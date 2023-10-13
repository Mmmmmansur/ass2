package FactoryMethod;

public class ComputerFactory { // наша фабрика
    public static Computer getComputer(String type, String ram, String hdd, String cpu){
        if("PC".equalsIgnoreCase(type)) // сравнивает данную строку с другой строкой, игнорируя регистр
            return new PC(ram, hdd, cpu); // если условие выполнено возвращает нам обьект класса ПК
        else if("Server".equalsIgnoreCase(type))
            return new Server(ram, hdd, cpu); // а тут возвращает сервер
        return null; // в ином случае нулл
    }
}