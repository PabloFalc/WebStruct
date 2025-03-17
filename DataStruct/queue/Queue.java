package queue;

import queue.Node;
public class Queue{

    public Node head;
    public Node tail;

    public Queue(){
        this.head = null;
        this.tail = null;

    }



    public boolean enqueue(int element){


        if(this.head == null){
            Node node = new Node(element, null);

            this.tail = node;
            this.head = node;
            printQueue();
           return true;
        }

        Node node = new Node(element,null);

        node.next = this.head;
        this.head = node;


        printQueue();
        return true;

    }


    public Node Dequeue(){

        if(this.head == null){
            throw new NullPointerException("operção com fila nula");
        }
        if(this.head == this.tail){
            Node element = this.head;

            this.head = null;
            this.tail =null;
            printQueue();

            return element;
        }
        Node element = this.tail;
        Node actual = this.head;

        while (actual.next != element){
            actual = actual.next;
        }

        actual.next = null;
        this.tail = actual;

        printQueue();
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
            System.out.print("(" + current.value + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }
}
