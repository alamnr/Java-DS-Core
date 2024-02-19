package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


interface Lamda{
    void lamda();
 }
public class LamdaTest {
    
    static List<String>  retainStringsOfLength3(List<String> strings){
        Predicate<String> pred = (s) -> s.length() == 3;
        List<String> listOfStringLength3 = new ArrayList<>();
        for (String elem : strings) {
            if(pred.test(elem)){
                listOfStringLength3.add(elem);
            }
        }
        return listOfStringLength3;
     }
    public static void main(String[] args) {
        

       Lamda l =  new Lamda() {

            @Override
            public void lamda() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'lamda'");
            }
            
        };

        Lamda lamda2 = () -> System.out.println("Puki marce");
//        lamda.lamda();
        lamda2.lamda();
        Runnable run = () -> System.out.println("I am running");
        run.run();
        Predicate<String> pred = (s) -> s.length() == 3;
        System.out.println(pred.test("asd"));
        Consumer<String> con = (s) -> System.out.println(s);
        con.accept("WTF");

        System.out.println(retainStringsOfLength3(Arrays.asList("gfd","hgyt","oiu")));

        // creating new instance , type casting, implements, throws
    }
    
}
