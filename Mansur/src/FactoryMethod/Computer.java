package FactoryMethod;

public abstract class Computer { //Супер класс, где хранятся методы нашей фабрики

    public abstract String getRAM();

    public abstract String getHDD();

    public abstract String getCPU();

    @Override // возвращает строковое представление объекта.
    public String toString() { // метод тустринг, чтобы получить значение
        return "RAM= " + this.getRAM() + ", HDD=" + this.getHDD() + ",CPU = " + this.getCPU();
    }
}