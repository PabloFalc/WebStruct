class Node{
    int value;
    Node next;
    Node prev;
    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

// deque class
public class ex2 {
    


    public Node head;
    public Node tail;
    public int length;


    public ex2(){
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
        }
        else{
            // entro pelo lado esquerdo, e agora é a head
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.length++;
        printQueue();
        return;
    }

    public void enqueueRigth(int element){

        Node newNode = new Node(element);

        

        // verifica se o tamanho da lista é null, 
        if(this.length == 0){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            // entro pelo lado direito, ou seja pela tail
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;

        }
        this.length++;
        printQueue();
        return;

    }


    public int dequeueLeft(){

        Node node = this.head;
 
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
        this.head.prev = null;
        node.next = null;
        
        
        this.length--;
        printQueue();
        return node.value;

    }

    public int dequeueRigth(){

        Node node = this.tail;

        
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
        this.tail = this.tail.prev;
        this.tail.next = null;
        node.prev = null;
        this.length--;
        printQueue();
        return node.value;
        





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

    public void moverDeque(int quant){
        Node current = this.tail;

        if(quant > this.length){
            throw new RuntimeException("quantidade maior que o tamanho da lista");
        }
        else if(quant == this.length){
            System.out.println("elementos já estão ordenados");
            return;
        }

        for(int i = 0; i< quant; i++){
            current = current.prev;
        }

        this.tail.next = this.head;
        this.head.prev = this.tail;
        this.head = current;
        this.tail = current.prev;
        this.tail.next = null;
        this.head.prev = null;
        printQueue();
    }



    public static void main(String[] args){

        ex2 deque = new ex2();

        deque.enqueueRigth(1);
        deque.enqueueRigth(2);
        deque.enqueueRigth(3);
        // deque.enqueueRigth(6);
        // deque.enqueueRigth(0);
        // deque.enqueueRigth(7);
        // deque.enqueueRigth(8);
        System.out.println("----------------");

        deque.moverDeque(0);
        // deque.moverDeque(1);

    }


}
