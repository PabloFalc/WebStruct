package priorityQueue;

public class Node {
    
    public int value;
    public Node next;
    public int priority;


    public Node(int value,  int priority){
        this.value = value;
        this.next = null;
        this.priority = priority;
    }

}
