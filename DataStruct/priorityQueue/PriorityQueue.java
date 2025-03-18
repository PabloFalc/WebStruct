package priorityQueue;


public class PriorityQueue<Type> {

    public Node<Type> head;
    public Node<Type> tail;
    public int length;


    public PriorityQueue(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

   

    private Node<Type> priorityVerification(int priority){
        Node<Type> current = this.head;

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


    public boolean enqueue(Type element, int priority){
        Node<Type> newNode = new Node<>(element, priority);
        
        if(this.length == 0){

            this.head = newNode;
            this.tail = newNode;
            length++;
            printQueue();
            return true;

        }
        Node<Type> current = priorityVerification(priority);
        
        if(this.head == current && current.priority >= priority){
            newNode.next = this.head;
            this.head = newNode;
            length++;
            printQueue();
            return true;
        }
        else if(current == this.tail){
            current.next = newNode;
            this.tail = newNode;
            length++;
            printQueue();
            return true;
        }

        
    
        newNode.next = current.next;
        current.next = newNode;

        printQueue();
        length++;
        return true;
    }

    // boolean enqueuePrioridade(Type valor,int priority) {
    //     Node<Type> novo = new Node<>(valor,priority);
    //     if (length == 0) {
    //         this.head = novo;
    //         this.tail = novo;
    //     } else {
    //         Node<Type> atual = this.head;
    //         while(atual.next != null && novo.priority > atual.next.priority){
    //             atual = atual.next;
    //         }
    //         if(atual.next == null){
    //             atual.next = novo;
    //             this.tail = novo;
    //         }else{
    //             novo.next = atual.next;
    //             atual.next = novo;
    //         }
    //     }
    //     length++;
    //     return true;
    // }

    public Type dequeue(){

        if(this.head == null && this.tail == null){
            throw new NullPointerException("operção com fila nula");
        }
        if(this.head == this.tail){
            Node<Type> element = this.head;

            this.head = null;
            this.tail =null;
            this.length--;
            printQueue();
            return element.value;
        }
        Node<Type> element = this.tail;
        Node<Type> current = this.head;

        while (current.next != element){
            current = current.next;
        }

        current.next = null;
        this.tail = current;
        this.length--;
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
            System.out.print("([" + current.priority + "] " + current.value + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }
}



