package org.myproject.concatenate;
import java.util.ArrayList;
import java.util.List;

public class Generics{
    public static void main(String[] args){

        List list = new ArrayList<>();
        list.add("hello");
        String s = (String) list.get(0);
        System.out.println(s);


        List<String> list2 = new ArrayList<>();
        list2.add("hi");
        String s2 = list2.get(0);
        System.out.println(s2);
    }
}