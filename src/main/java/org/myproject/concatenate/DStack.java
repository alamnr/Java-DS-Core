package org.myproject.concatenate;

public class DStack {
    int[] stack ;
    int top = 0;
    int stackSize;
    public DStack(int size){
        stackSize = size;
        stack = new int[size];
    }

   
    public void push(int data){
        if(top ==   stackSize){
            expand();
        }
            stack[top] = data;
            top++;
                
    }

    public void expand(){
        
        int[] newStack = new int[size()*2];
        System.arraycopy(stack, 0, newStack, 0, size());
        stack = newStack; 
        stackSize = newStack.length;
    }


    public int pop(){
        int data = 0;
        if(isEmpty()){
            System.out.println("Stack is empty ");
        } else {
                
            top--;
            data = stack[top];
            stack[top] = 0;
            if(size()<=(stackSize/2)/2){
                shrink();
            }
        }
        return data;
    }
    public void shrink(){
        // int currentSize = size();
        // if(currentSize<=(stackSize/2)/2){
            stackSize = stackSize/2;
        //}
        int[] newStack = new int[stackSize];     
        System.arraycopy(stack, 0, newStack, 0, size());
        stack = newStack;
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