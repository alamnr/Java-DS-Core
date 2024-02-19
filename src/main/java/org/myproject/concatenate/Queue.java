package org.myproject.concatenate;

public class Queue {

    int[] queue;
    int initSize;
    int size;
    int front;
    int rear;

    public Queue(int size){
        this.queue = new int[size];
        this.initSize =  size;
    }

    public void enQueue(int data){
        if(!isFull()){
            queue[rear] =  data;
            rear = (rear+1)%initSize;
            size = size+1;
        } else {
            System.out.println("Queue is full");
        }
        
    }
    public int deQueue(){
        int data = queue[front];
        if(!isEmpty()){
            front = (front+1)%initSize;
            size = size - 1;
        } else {
            System.out.println("Queue is empty");
        }
        
        return data;
    }
    public void show(){
        System.out.print("Elements : ");
        for(var i =0;i<size;i++){
            System.out.print(queue[(front+i)%initSize] +" ");

        }
        System.out.println();

        for(int n: queue){
            System.out.print(n+"  ");
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public boolean  isFull(){
        return getSize() == initSize;
    }
}
