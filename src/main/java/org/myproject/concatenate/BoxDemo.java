package org.myproject.concatenate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoxDemo {
    public static <U> void addBox(U u, List<Box<U>> boxes){
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void  outputBoxes(List<Box<U>> boxes){
        int counter = 0;
        for(Box<U> box: boxes){
            U boxContent = box.get();
            System.out.println("Box #" + counter + " contains [" +
             boxContent.toString() + "]");
            counter++;
        }
    }
    public static void main(String[] args) {
        List<Box<Integer>> listOfIntegerBox = new ArrayList<>();
        BoxDemo.<Integer>addBox(Integer.valueOf(15), listOfIntegerBox);
        BoxDemo.addBox(Integer.valueOf(10), listOfIntegerBox);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBox);
        BoxDemo.outputBoxes(listOfIntegerBox);

        Map<String,List<String>> myMap = new HashMap<>();

        List<String> listOne = Collections.emptyList();
    }
}
