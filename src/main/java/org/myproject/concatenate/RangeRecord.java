package org.myproject.concatenate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public record RangeRecord(int start, int end) implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer> (){
            private int index = start;
            @Override
            public boolean hasNext(){
                return index < end;
            }

            @Override
            public Integer next(){
                if(index > end){
                    throw new NoSuchElementException(" "+ index);
                }
                int current = index;
                index++;
                return current;
            }
        };
    }
    public static void main(String[] args) {
        RangeRecord record = new RangeRecord(0, 5);
        for (Integer integer : record) {
            System.out.println(integer);
        }
        List<String> strings = List.of("one","two","three","four","five");
        Set<String> set = new HashSet<>();
        set.addAll(strings);
        set.forEach(System.out::println);
        
        SortedSet<String> stringsSorted = new TreeSet<>(Set.of("a", "b", "c", "d", "e", "f"));
        SortedSet<String> subSet = stringsSorted.subSet("aa", "d");
        System.out.println("sub set = " + subSet);
        //subSet.add("a");
        //System.out.println("sub set = " + subSet);

        NavigableSet<String> navigableSets = new TreeSet<>(Set.of("a","b","c","d","e"));
        System.out.println(navigableSets);
        NavigableSet<String> reverseNavigableSet = navigableSets.descendingSet();
        System.out.println(reverseNavigableSet);
    }

    
}
