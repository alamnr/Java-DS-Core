package org.myproject.concatenate;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        
        Optional<Cat> myOptionalCat = findCatByName(Optional.ofNullable("Fred"));
        if(myOptionalCat.isPresent()){
            //Cat cat = myOptionalCat.get();
            System.out.println(myOptionalCat.get().getAge());
        }
        else {
            System.out.println(0);
        }

        Cat cat = myOptionalCat.orElse(new Cat("Uknown",0));
        
        System.out.println(cat.getName());
        System.out.println(myOptionalCat.map(Cat::getAge).orElse(0));
        cat = myOptionalCat.orElseThrow();
    }
    
    private static Optional<Cat> findCatByName(Optional<String> name){
        Cat cat= new Cat(name.orElse("other"), 3);
        //return  Optional.ofNullable(cat);
        return  Optional.ofNullable(null);
    }
}
