package org.myproject.concatenate;

public class Util {

    public static <K,V> boolean compare(MyPair<K,V> p1, MyPair<K,V> p2){
        return p1.getKey().equals(p2.getKey())&& p1.getValue().equals(p2.getValue());
    }
    
    
}
