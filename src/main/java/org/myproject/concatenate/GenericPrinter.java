package org.myproject.concatenate;

public class GenericPrinter<T extends Animal, V > {
    T thingToPrint;
    V other;

    public GenericPrinter(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print() {
        thingToPrint.bark();
        System.out.println(thingToPrint);
    }
}