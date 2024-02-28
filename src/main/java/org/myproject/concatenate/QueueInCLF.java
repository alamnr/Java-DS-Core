package org.myproject.concatenate;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueInCLF {

    public static void main(String[] args) {
        Deque<Integer> dqueue1 = new ArrayDeque<>();
        Deque<Integer> dqueue2 = new LinkedList<>();
        Queue<Integer> dqueue3 = new PriorityQueue<>();

        dqueue1.push(1);dqueue1.push(10); dqueue1.push(8);  dqueue1.push(13);
        //dqueue1.pop(); 
         System.out.println(dqueue1.peek()); 
        print(dqueue1);
        dqueue2.push(1);dqueue2.push(10); dqueue2.push(8);  dqueue2.push(13);

        dqueue3.add(1);dqueue3.add(10); dqueue3.add(8);  dqueue3.add(13);

    }
    static void print(Queue<Integer> queue){
        System.out.println();
        for (Integer object : queue) {
            System.out.print(" " +object);
        }
    }
}
