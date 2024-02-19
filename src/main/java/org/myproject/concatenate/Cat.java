package org.myproject.concatenate;
@VeryImportant
public class Cat extends Animal{

    @ImportantString
    String name;
    private int age;

    
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(){
        
    }
    @RunImmediately(times=3)
    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @Override
    void bark() {
     System.out.println("Meow");
    }

    @Override
    public String toString(){
        return "I'm Cat";
    }
    
}
