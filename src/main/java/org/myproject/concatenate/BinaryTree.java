package org.myproject.concatenate;

class NodeTree {
    int data;
    NodeTree left;
    NodeTree right;

    public NodeTree(int data){
        this.data = data;
    }
}
public class BinaryTree {
    
    NodeTree root;
    public void insert(int data){
        root = insertRec(root, data);
    }
    public NodeTree insertRec(NodeTree root, int data){
        if(root == null){
            root = new NodeTree(data);
        } else if(data < root.data){
            root.left = insertRec(root.left, data);
        } else if (data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // In Order (L, Ro, Ri)
    // Pre Order (Ro, L, Ri)
    // Post Order (L,Ri, Ro )
    public void inOrder(){
        inOrderTraversal(root);
    }

    public void inOrderTraversal(NodeTree root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.print(root.data + "  ");
            inOrderTraversal(root.right);
        }

    }

    public void preOrder(){
        preOrderTraversal(root);
    }

    public void preOrderTraversal(NodeTree root){
        if(root != null){
            System.out.print(root.data + "  ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            
        }
    }
}
