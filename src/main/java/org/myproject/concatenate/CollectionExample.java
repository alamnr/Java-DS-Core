package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class CollectionExample {

    public static void main(String ... args){
        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        System.out.println("strings= "+strings);
        Collection<String> first = new ArrayList<>();
        first.add("one");
        first.add("two");

        Collection<String> second = new ArrayList<>();
        second.add("one");
        second.add("two");

        System.out.println("Is first contained in strings : " + strings.contains(first));
        System.out.println("Is second contained in strings : " + strings.contains(second));

        boolean hasStringChanged = strings.addAll(first);

        System.out.println("Has string changed ? " + hasStringChanged);
        System.out.println(" strings = "+ strings);

        System.out.println(Arrays.toString(strings.toArray()));

        if(strings.contains("one")){
            System.out.println("One is here");
        }
        if(!strings.contains("three")){
            System.out.println("Three is not here");
        }
        if(!strings.contains(new Area(5, 6))){
            System.out.println("Area object is not here");
        }
        strings.remove("one");
        System.out.println("strings= "+ strings);

        Predicate<String> isNull = s -> Objects.isNull(s); //Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);
        
        strings.add(null);
        strings.add("");
        strings.add(null);
        strings.add("");

        System.out.println("strings : "+strings);

        strings.removeIf(isNullOrEmpty);

        System.out.println("strings : "+ strings);

        for(String str: strings){
            System.out.println(str);
        }
        System.out.println("========================================");
        strings = List.of("one","two","three","four","five");
        for (Iterator<String> it = strings.iterator(); it.hasNext();) {
            String elem = it.next();
            if(elem.length() == 3){
                System.out.println(elem);
            }
        }

        Iterator<String> it = strings.iterator();
        while (it.hasNext()) {
          String  elem =  it.next();
          //strings.remove(elem); 
              
        }

        System.out.println("strings : "+ strings);

        for(int i :  new Range(1,5)){
            System.out.println("i = "+i);
        }

        List<String> list = new  ArrayList<>(List.of("0","1","2","3","4"));
        System.out.println(list);
        list.subList(2, 5).clear();
        System.out.println(list);
        List<String> list1 = new ArrayList<>(List.of("100","101","201"));
        list.addAll(0,list1);
        System.out.println(list);
        list.sort(null);
        System.out.println(list);
        

        List<String> numbers = Arrays.asList("One","Two","Three");
        for(ListIterator<String> iter = numbers.listIterator(); iter.hasNext();){
            String nextElement = iter.next();
            if(Objects.equals(nextElement,"Two")){
                iter.set("2");
            }

        }
        System.out.println(numbers);

        Set s1 = new HashSet<>();
        Set s2 = new LinkedHashSet<>();

        if( s1 instanceof HashSet){
            System.out.println("yea s1");
        }

    }
    
}
