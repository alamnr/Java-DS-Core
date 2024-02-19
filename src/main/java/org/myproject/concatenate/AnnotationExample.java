package org.myproject.concatenate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationExample {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat cat = new Cat("Stella", 0);

        if(cat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("This is very important");
        } else {
            System.out.println("This is not very important. ");
        }
        for(Method method: cat.getClass().getMethods()){
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately runImmediately = method.getAnnotation(RunImmediately.class);
                //System.out.println("here");
                for(var i=0; i< runImmediately.times(); i++){
                    
                    System.out.println(method.invoke(cat));
                }
                
            }
        }
        
        for(Field field: cat.getClass().getDeclaredFields()){
            
            if(field.isAnnotationPresent(ImportantString.class)){
                    Object obj = field.get(cat);
      
                    if(obj instanceof String stringValue){
                        System.out.println(stringValue.toUpperCase());
                    }
                 }
        }
    }
    
}
