package org.myproject.concatenate;

@SuppressWarnings("unchecked")
public class WarningDemo {
    public static void main(String[] args)    {
        Box<Integer> bi;
        bi = createBox();
    }
    
    static Box createBox(){
        return new Box();
    }
}
