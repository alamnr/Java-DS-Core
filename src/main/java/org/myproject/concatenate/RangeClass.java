package org.myproject.concatenate;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeClass implements Iterable<Integer> {
    private final int start;
    private final int end;

    public RangeClass(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
       return new Iterator<Integer> (){
            private int index = start;
            @Override
            public boolean  hasNext(){
                return index < end;
            }

            @Override
            public Integer next(){
                if(index > end){
                    throw new NoSuchElementException(" "+ index);
                }
                int currentIndex = index;
                index++;
                return currentIndex;
            }
       };
    }    
    public static void main(String[] args) {
        RangeClass clazz  = new RangeClass(1, 10);
        for (Integer integer : clazz) {
            System.out.println(integer);
        }
    }
}