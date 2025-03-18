package priorityQueue;

public class Node <Type>{
    
    public Type value;
    public Node<Type> next;
    public int priority;


    public Node(Type value,  int priority){
        this.value = value;
        this.next = null;
        this.priority = priority;
    }

}
