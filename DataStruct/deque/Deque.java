package deque;

import deque.Node;

public class Deque {

    public Node head;
    public Node tail;
    public int length;


    public Deque(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // entrar pelo lado esquerdo da fila, ou seja pela head
    public void enqueueLeft(int element){

        Node newNode = new Node(element);

        // verifica se o tamanho da lista é null, 
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }

        // entro pelo lado esquerdo, e agora é a head
        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
        this.length++;
        return;
    }

    public void enqueueRigth(int element){

        Node newNode = new Node(element);

        // verifica se o tamanho da lista é null, 
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            return;
        }

        // entro pelo lado direito, ou seja pela tail
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
        return;

    }


    public Node dequeueLeft(){

        Node node = this.head;
        // System.out.println("----LEFT---");
        // System.out.println("head: "+ head.value);
        // System.out.println("tail: "+ tail.value);
        // System.out.println("length: "+ length);
        // System.out.println("-------");

        if(this.length == 0){
            throw new NullPointerException("erro, deque está vazio");
            
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            return node;
        }
        this.head = this.head.next;
        this.head.previous = null;
        node.next = null;
        
        
        this.length--;
        return node;

    }

    public Node dequeueRigth(){

        Node node = this.tail;
        // System.out.println("---RIGTH----");
        // System.out.println("tail: "+ tail.value);
        // System.out.println("head: "+ head.value);
        // System.out.println("length: "+ length);
        // System.out.println("-------");
        
        if(this.length == 0){
            throw new NullPointerException("erro, deque está vazio");
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            return node;
        }
        this.tail = this.tail.previous;
        this.tail.next = null;
        node.previous = null;
        this.length--;

        return node;
        





    }


    public void printQueue() {
        Node current = this.head;

        if (this.head == null) {
            System.out.println("null");
            return;
        }

        // Percorre a lista e imprime no formato correto
        while (current != null) {
            System.out.print("("+ current.value + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }

}
