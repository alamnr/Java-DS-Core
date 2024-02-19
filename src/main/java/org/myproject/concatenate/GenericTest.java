package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {
    
    public static void main(String ... args){
        // GenericPrinter<Integer> intPrinter = new GenericPrinter<>(56);
        // intPrinter.print();

        // GenericPrinter<Double> doublePrinter = new GenericPrinter<>(45.5);
        // doublePrinter.print();

        // GenericPrinter<String> stringPrinter = new GenericPrinter<>("I'm String");
        // stringPrinter.print();

        GenericPrinter<Cat, Dog> catPrinter = new GenericPrinter<>(new Cat());
        catPrinter.print();

        GenericPrinter<Dog,Integer> dogPrinter = new GenericPrinter<>(new Dog());
        dogPrinter.print();

        //List<Object> list = new ArrayList<>();
        List<Cat> list = new ArrayList<>();
        list.add(new Cat());
        //list.add(new Dog());

        Cat cat = list.get(0);

        shout(12,5.2);
        shout("string ", new Cat()).bark();
        shout(new Cat(), new Dog()).bark();;
        //shout(new Dog());
        // List<Object> listToPrint = Arrays.asList(1,2.5,"f");
        // printList(listToPrint);

        // List<Integer>  intList = Arrays.asList(1,2,3);
        // printList(intList);
        
        List<Cat> catList = Arrays.asList(new Cat(), new Cat());
        printList(catList);
        String s= "hhhhhhhhhhhhhhh - ";
        passString(s);

        System.out.println(s);
    }

    public static <T, V> V shout(T thingToShout, V other){
        System.out.println(thingToShout + " Shouting ");
        System.out.println(other + " Shouting ");

        return other;
    }

    private static void printList(List<? extends Animal> list){
        System.out.println(list);
    }

    private static void passString(String s){
        s =  s.concat("00000000000000");
        System.out.println(s);
    }
}
