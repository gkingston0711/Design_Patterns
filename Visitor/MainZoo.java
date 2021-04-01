package com.company;
import java.util.Stack;

/** VERY SIMPLE ITERATOR **/
class animalIterator {

    Stack<Node> stack = new Stack<Node>();

    public animalIterator(Node root) {
        pushToLeft(root);
    }

    public boolean hasNext(){
        if(stack.empty()){
            return false;
        }return true;
    }
    
    public String next(){
        Node node = stack.pop();
        pushToLeft(node.right);
        return node.key;
    }
    //BELOW IS IMPORTANT SINCE WANT TO ITERATE INORDER TRAVERSAL
    private void pushToLeft(Node node){
        if (node != null){
            stack.push(node);
            pushToLeft(node.left);
        }
    }
}


/** EVERY THING FOR TREE NEEDED IS BELOW **/
class Node{
    String key;
    Node left, right;

    public Node(String item) {
        key = item;
        left = right = null;
    }

}

class binarySearchTree {

    Node root;

    binarySearchTree() {
        root = null;
    }

    void insert(String key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, String key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        int temp = key.compareTo(root.key);

        if (0 > temp)
            root.left = insertRec(root.left, key);
        else if (0 < temp)
            root.right = insertRec(root.right, key);

        return root;
    }
    //Wrapper for inOrderRec
    void inorder() {
        inOrderRec(this.root);
    }

    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.key);
            inOrderRec(root.right);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        binarySearchTree zoo = new binarySearchTree();

        zoo.insert("tiger");
        zoo.insert("dolphin");
        zoo.insert("eagle");
        zoo.insert("whale");
        zoo.insert("otter");
        zoo.insert("seal");
        zoo.insert("bear");
        zoo.insert("sloth");
        zoo.insert("zebra");
        zoo.insert("wolf");
        zoo.insert("lion");

        animalIterator iterator = new animalIterator(zoo.root);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
