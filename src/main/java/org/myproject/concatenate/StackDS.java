package org.myproject.concatenate;

public class StackDS {
    public static void main(String ... args){
        // Stack stack = new Stack(5);
        // stack.push(25);
        // stack.push(14);
        // stack.push(21);

        // System.out.println(stack.pop());

        // System.out.println(stack.peek());
        // System.out.println("Size is  "+ stack.size());
        // stack.pop();
        // stack.pop();
        // System.out.println("Is empty "+stack.isEmpty());
        // stack.push(14);
        // stack.push(36);
        // stack.push(85);
        
        // stack.show();
        // stack.pop();
        // stack.pop();
        // stack.pop();
        // stack.show();

        // stack.pop();
        // stack.pop();
        // stack.show();        

        // stack.pop();

        StackGeneric sg = new StackGeneric<>(String.class, 5);
        sg.push("ABC");
        sg.push("DEF");
        sg.push("GHI");
        sg.show();


        DStack dStack = new DStack(2);
        dStack.push(52);
        dStack.push(41);
        dStack.push(15);
        dStack.push(35);
        dStack.push(65);
        dStack.show();

        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.pop();
        dStack.show();
        
    }
}