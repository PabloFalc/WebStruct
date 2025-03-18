package queue;

public class Queue<Type>{

    public Node<Type> head;
    public Node<Type> tail;

    public Queue(){
        this.head = null;
        this.tail = null;

    }



    public boolean enqueue(Type element){


        if(this.head == null){
            Node<Type> node = new Node<>(element);

            this.tail = node;
            this.head = node;
            printQueue();
           return true;
        }

        Node<Type> node = new Node<>(element);

        node.next = this.head;
        this.head = node;


        printQueue();
        return true;

    }


    public Type Dequeue(){

        if(this.head == null){
            throw new NullPointerException("operção com fila nula");
        }
        if(this.head == this.tail){
            Node<Type> element = this.head;

            this.head = null;
            this.tail =null;
            printQueue();

            return element.value;
        }
        Node<Type> element = this.tail;
        Node<Type> actual = this.head;

        while (actual.next != element){
            actual = actual.next;
        }

        actual.next = null;
        this.tail = actual;

        printQueue();
        return element.value;
    }

    public void printQueue() {
        Node<Type> current = this.head;

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
