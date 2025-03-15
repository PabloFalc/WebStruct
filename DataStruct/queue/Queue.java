package queue;

public class Queue{

    public Node head;
    public Node tail;

    public Fila(Node tail, Node head){
        this.head = null;
        this.tail = null;

    }



    public boolean enqueue(int element){


        if(this.head == null || this.tail == null){
            Node node = new Node(element, null);

            this.tail = node;
            this.head = node;
            System.out.println("lista vazia, elemento add");
           return true;
        }
        System.out.println("Lista tem mais de um elemento");
        Node node = new Node(element,null);

        System.out.println(node.value);

        node.next = this.head;
        this.head = node;



        return true;

    }


    public Node Dequeue(){

        if(this.head == null || this.tail == null){
            throw new NullPointerException("operção com fila nula");
        }
        if(this.head == this.tail){
            Node element = this.head;

            this.head = null;
            this.tail =null;

            System.out.println("apenas um elemento, na lista, e foi removido");
            return element;
        }
        System.out.println("tem mais de 1 elemento na fila");
        Node element = this.tail;
        Node actual = this.head;

        while (actual.next != element){
            actual = actual.next;
        }

        actual.next = null;
        this.tail = actual;

        System.out.println("Seu elemento foi: "+ element.value);
        return element;
    }
}
