package org.myproject.concatenate;

public class Dog extends Animal{

    @Override
    public void bark(){
        System.out.println("Woof");
    }

    @Override
    public String toString(){
        return "I'm Dog";
    }
    
}
