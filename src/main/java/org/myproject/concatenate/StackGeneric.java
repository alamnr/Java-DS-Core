package org.myproject.concatenate;

import java.lang.reflect.Array;

public class StackGeneric<T> {

    T[] stack ;
    int top = 0;
    int stackSize;
    public StackGeneric(Class<T> clazz ,int size){
        stackSize = size;
        stack = (T[]) Array.newInstance(clazz, size);
    }

   
    public void push(T data){
        if(top == stackSize){
            System.out.println("Stack is full ");
          
        } else {
            stack[top] = data;
            top++;
        }        
    }


    public T pop(){
        T data = null;
        if(isEmpty()){
            System.out.println("Stack is empty ");
        } else {
                
            top--;
            data = stack[top];
            stack[top] = null;
        }
        return data;
    }

    public T peek(){
        return stack[top-1];
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        return top <= 0;
    }

    public void show(){
        for (T elem : stack) {
            System.out.print(elem + "  ");   
        }
        System.out.println();
    }
    
}
