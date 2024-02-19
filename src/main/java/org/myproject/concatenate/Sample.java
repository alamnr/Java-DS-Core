package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyList<T>{
    public void add(T elem){
        System.out.println("Called.....");
    }
}

public class Sample {

    public static <T> void copy(List<T> from,List<T> to){
        for(var e:from){
            to.add(e);
        }
    }

    public static <T extends Comparable<T>> void copyAllBut(List<T> from, List<T> to, T exclude){
        for(var e: from){
            if(e.compareTo(exclude) != 0){
                to.add(e);
            }
        }
    }
    public static void main(String... args){

        MyList<Integer> myliList = new MyList<>();
        myliList.add(1);
        //myliList.add("hi");
        List<Integer> number1 = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> number2 = new ArrayList<>(Arrays.asList(4,2,5));

        System.out.println(number1);
        System.out.println(number2);

        //copy(number1,number2);
        copyAllBut(number1, number2, 2);

        System.out.println(number1);
        System.out.println(number2);
        
        // List<Integer> numbers = new ArrayList<>();

        // numbers.add(1);
        // numbers.add(2);
        // numbers.add(3);

        // int total=0;
        // for(int e: numbers){
        //     total += e;
        // }
        // System.out.println(total);
    }
}