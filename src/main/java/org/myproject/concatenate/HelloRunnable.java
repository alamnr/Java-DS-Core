package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import com.sun.security.auth.UserPrincipal;

public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello thread implements  runnable -" + Thread.currentThread().getName());

    }

    public static void main(String[] args) {

        // System.out.println("Main thread - "+ Thread.currentThread().getName());
        // (new Thread(new HelloRunnable())).start();

        // (new HelloThread()).start();

        // (new Thread(new HelloRun())).start();


        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        System.out.println("strings : "+ strings);
        strings.remove("one");
        System.out.println("strings : "+ strings);

        if(strings.contains("two")){
            System.out.println("Two is here");
        }
        if(!strings.contains("three")){
            System.out.println("Three is not here");
        }
        UserPrincipal user = new UserPrincipal("Reba");
        if(!strings.contains(user)){
            System.out.println("Reba is not here");
        }

        strings.add("three");
        strings.add("four");
        strings.add("five");
        strings.add("six");

        Object[] tabString1= strings.toArray();
        // for (Object object : tabString1) {
        //     System.out.println("collection to array -1: " + (String)object);
        // }

        System.out.println(Arrays.toString(tabString1));

        String[] tabString2 = strings.toArray(new String[] {}); // passing an empty array
        String[] tabString3 = strings.toArray(new String[15]); // passing an array of size 15

        System.out.println(Arrays.toString(tabString2));
        System.out.println(Arrays.toString(tabString3));

        strings = List.of("one","two");
        String[] largerTab = {"three", "three", "three", "I", "was", "there"};
        System.out.println("largerTab = " + Arrays.toString(largerTab));

        String[] result = strings.toArray(largerTab);
        System.out.println("result = " + Arrays.toString(result));

        String[] zeroLengthTab = {};
        result = strings.toArray(zeroLengthTab);

        System.out.println("zeroLengthTab = " + Arrays.toString(zeroLengthTab));
        System.out.println("result = " + Arrays.toString(result));

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        
        Collection<String> anotherStrings = new ArrayList<>();
        anotherStrings.add(null);
        anotherStrings.add("one");
        anotherStrings.add("");
        anotherStrings.add("");
        anotherStrings.add("two");
        anotherStrings.add(null);
        anotherStrings.add("three");
        System.out.println("anotherStrings = " + anotherStrings);
        anotherStrings.removeIf(isNullOrEmpty);
        System.out.println("filtered anotherStrings = " + anotherStrings);

        Collection<String> stringsToIterate = List.of("one","two","three","four");
        for (Iterator<String> it = anotherStrings.iterator(); it.hasNext();) {
            String elem = it.next();
            if(elem.length()==3){
                //it.remove();
                anotherStrings.remove(elem);
            }
        }
        System.out.println(anotherStrings);
            

    }
    
}

class HelloThread extends Thread {

    @Override
    public void run() {
      System.out.println("Hellothread extends Thread - "+Thread.currentThread().getName());
    }
    
}

class HelloRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Thread another - " + Thread.currentThread().getName());    
    }
    
}