package org.myproject.concatenate;
// public class Box{
//     private Object obj;
//     public void set(Object obj){
//         this.obj = obj;
//     }
//     public Object get(){
//         return this.obj;
//     }
// }
public class Box<T>{
    private T t;
    public void set(T t){
        this.t= t;
    }
    public T get(){
        return t;
    }

    public <U extends Number> void inspect(U u){
        System.out.println("T : "+ t.getClass().getName());
        System.out.println("U: "+ u.getClass().getName());
    }

    public void boxTest(Box<Number> n){
        return;
    }
    public static void main(String... args){
        Box<Integer> b = new Box<>();
        b.set(8);

        System.out.println(b.get());
       // b.set('h');
        System.out.println(b.get());
        //b.inspect("gffh");

        //b.set(new Double(10.1));
        //b.boxTest(b);
    }
}