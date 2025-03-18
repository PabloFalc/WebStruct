package stack;

public class Node <Type>{

    Type value;
    Node<Type> next;
    Node<Type> prev;

    public Node(Type value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}