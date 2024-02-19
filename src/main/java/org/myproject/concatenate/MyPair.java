package org.myproject.concatenate;

public class MyPair<K,V> {

    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        MyPair<Integer,String> p1= new MyPair<Integer,String>(1, "apple");
        MyPair<Integer,String> p2 = new MyPair<>(5,"pear");
        System.out.println(Util.compare(p1, p2));
    }
    
}
