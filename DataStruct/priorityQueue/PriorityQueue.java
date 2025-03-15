package priorityQueue;

import priorityQueue.Node;

public class PriorityQueue {

    public Node head;
    public Node tail;
    public int length;


    public PriorityQueue(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

   

    private Node priorityVerification(int priority){
        Node current = this.head;

        for(int i = 0; i < length - 1 ;i++){

            if (current.next != null && priority > current.priority && priority <= current.next.priority) {
                
                return current;
            }
            else if(priority<=current.next.priority){
                return current;
            }

            current= current.next;
           
        }
        return current;
    }


    public boolean enqueue(int element, int priority){
        Node newNode = new Node(element, priority);
        
        if(this.length == 0){

            
            this.head = newNode;
            this.tail = newNode;
            length++;
            return true;

        }
        Node current = priorityVerification(priority);

        
        if(this.head == current && current.priority >= priority){
            newNode.next = this.head;
            this.head = newNode;
            length++;
            return true;
        }
        else if(current == this.tail){
            current.next = newNode;
            this.tail = newNode;
            length++;
            return true;
        }

        
    
        newNode.next = current.next;
        current.next = newNode;

        
        length++;
        return true;
    }

    public Node dequeue(){

        if(this.head == null && this.tail == null){
            throw new NullPointerException("operção com fila nula");
        }
        if(this.head == this.tail){
            Node element = this.head;

            this.head = null;
            this.tail =null;

            return element;
        }
        Node element = this.tail;
        Node current = this.head;

        while (current.next != element){
            current = current.next;
        }

        System.out.println("element: " +element.value);
        System.out.println("current: " +current.value);
        current.next = null;
        this.tail = current;

        System.out.println("Seu elemento foi: "+ element.value);
        return element;
    }




    public void printQueue() {
        Node current = this.head;

        if (this.head == null) {
            System.out.println("null");
            return;
        }

        // Percorre a lista e imprime no formato correto
        while (current != null) {
            System.out.print("([" + current.priority + "] " + current.value + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }
}



