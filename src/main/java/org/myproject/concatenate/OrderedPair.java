package org.myproject.concatenate;

public class OrderedPair<K,V> implements Pair<K,V>{
    private K key;
    private V value;

    public OrderedPair(K key, V val){
        this.key=key;
        this.value = val;
    }

    @Override
    public K getKey() {
        return  key;
    }

    @Override
    public V getValue() {
        return value;
    }

    
    public static void main(String[] args) {
        OrderedPair<String,Integer> orderedPair = new OrderedPair<String,Integer>("Soe", 5);
        OrderedPair<String,Integer> orderedPair2 = new OrderedPair<>("Soe", 5);
        OrderedPair<String,String> orderedPair3 = new OrderedPair<String,String>("John", "Doe");
        OrderedPair<String,Box<Integer>> orderedPair4 = new OrderedPair<String,Box<Integer>>("dshjgf", new Box<Integer>());

        Box<String> stringBox = new Box<>();
        Box rawBox = new Box();
        rawBox = stringBox;
        stringBox = rawBox;
    }

}
