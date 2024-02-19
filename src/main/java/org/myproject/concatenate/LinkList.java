package org.myproject.concatenate;

public class LinkList<T> {
    
    Node head;


    public <T> void insert(T data){

        Node  n  = new Node();
        n.data = data;
        n.next = null;

        if(this.head==null){
            this.head = n;
        } else {
            Node nodeStartedHereToTraverse = head;
            while(nodeStartedHereToTraverse.next!=null){
                nodeStartedHereToTraverse = nodeStartedHereToTraverse.next;
            }
            nodeStartedHereToTraverse.next = n;
        }
    }

    public <T> void insertAtStart(T data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public <T> void  inserAtIndex(int index, T data){
        
        if(index == 0){
          insertAtStart(data);   

        } else {
            
            Node node = new Node();
            node.data = data;
            node.next = null;

            Node toTraverse = head;
            for(var i=0;i<index-1;i++){
                
                toTraverse = toTraverse.next;
            }
            if(toTraverse == null || toTraverse.next == null ){
                throw new UnsupportedOperationException("");
            }
            node.next = toTraverse.next;
            toTraverse.next = node;
        }        
    }

    public void deleteAt(int index){

        if(index == 0){
            head = head.next;
        } else {
            Node n = head;
            Node n1 = null;
            for(var i=0;i<index-1;i++){
                if(n == null  || n.next == null ){
                    throw new UnsupportedOperationException("");
                }
                n = n.next;
            }
           
            n1=n.next;
            if(n1 == null){
                throw new UnsupportedOperationException("");
            }
            n.next = n1.next;
            //System.out.println("n1 - "+n1.data);
            n1 = null;
        }
    }

    public void show(){
        Node n = this.head;
        while(n.next!=null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
}
