package org.myproject.concatenate;

public class QueueDS {

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        // queue.enQueue(5);
        // queue.enQueue(2);
        // queue.enQueue(7);
        // queue.enQueue(3);
        
        queue.deQueue();
        queue.deQueue();
    
        //  queue.enQueue(9);
        //  queue.enQueue(1);
        // queue.enQueue(19);
        // queue.enQueue(15);
        queue.show();

        System.out.println();
        System.out.println(" Is empty : " + queue.isEmpty());
        System.out.println("Is full: " + queue.isFull());
        System.out.println("Size  "+ queue.getSize());
    }
    
}
