package deque;

public class Deque<Type> {

    public Node<Type> head;
    public Node<Type> tail;
    public int length;


    public Deque(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // entrar pelo lado esquerdo da fila, ou seja pela head
    public void enqueueLeft(Type element){
        
        Node<Type> newNode = new Node<>(element);
        
        if(element == null){
            throw new RuntimeException("elemento vazio");
        }
        // verifica se o tamanho da lista é null, 
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            printQueue();
            return;
        }

        // entro pelo lado esquerdo, e agora é a head
        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
        this.length++;
        printQueue();
        return;
    }

    public void enqueueRigth(Type element){

        Node<Type> newNode = new Node<>(element);

        if(element == null){
            throw new RuntimeException("elemento vazio");
        }

        // verifica se o tamanho da lista é null, 
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
            this.length++;
            printQueue();
            return;
        }

        // entro pelo lado direito, ou seja pela tail
        newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
        printQueue();
        return;

    }


    public Type dequeueLeft(){

        Node<Type> node = this.head;
 
        if(this.length == 0){
            throw new NullPointerException("erro, deque está vazio");
            
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            printQueue();
            return node.value;
        }
        this.head = this.head.next;
        this.head.previous = null;
        node.next = null;
        
        
        this.length--;
        printQueue();
        return node.value;

    }

    public Type dequeueRigth(){

        Node<Type> node = this.tail;

        
        if(this.length == 0){
            throw new NullPointerException("erro, deque está vazio");
        }
        else if(this.length == 1){
            this.head = null;
            this.tail = null;
            this.length--;
            printQueue();
            return node.value;
        }
        this.tail = this.tail.previous;
        this.tail.next = null;
        node.previous = null;
        this.length--;
        printQueue();
        return node.value;
        





    }


    public void printQueue() {
        Node<Type> current = this.head;

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
