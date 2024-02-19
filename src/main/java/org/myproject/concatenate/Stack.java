package org.myproject.concatenate;

public class Stack {

    int[] stack ;
    int top = 0;
    int stackSize;
    public Stack(int size){
        stackSize = size;
        stack = new int[size];
    }

   
    public void push(int data){
        if(top == stackSize){
            System.out.println("Stack is full ");
          
        } else {
            stack[top] = data;
            top++;
        }        
    }


    public int pop(){
        int data = 0;
        if(isEmpty()){
            System.out.println("Stack is empty ");
        } else {
                
            top--;
            data = stack[top];
            stack[top] = 0;
        }
        return data;
    }

    public int peek(){
        return stack[top-1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top <= 0;
    }

    public void show(){
        for (int elem : stack) {
            System.out.print(elem + "  ");   
        }
        System.out.println();
    }
    
}
