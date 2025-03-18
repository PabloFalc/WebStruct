package list;

class Node <Type>{

    public Type value;
    public Node<Type> next;

    public Node(Type value){
        this.value = value;
        this.next = null;
    }
}


public class CircularLinkedList<Type> {
    
    public Node<Type> head;
    public int length;
    
    public CircularLinkedList(){
        this.head = null;
        this.length = 0;
    }


    public void add(Type element, int position){

        Node<Type> newNode = new Node<>(element);

        // if (position > length -1) throw new RuntimeException("posição inválida");
        
        
        if(this.head == null){
            this.head = newNode;
            this.head.next = newNode;
            this.length++;
            printList();
            return;
        }

        int iterator = 0;
        Node<Type> current = this.head;

        // garantir o loop caso a posição seja 0
        if (position <= 0) {
            for(iterator = 1; iterator < this.length; iterator++){
                current = current.next;
            }
            newNode.next = this.head;
            this.head = newNode;
            current.next = this.head;
            current.next =this.head;
            this.length++;
            printList();
            return;
        }
        else{     
            // caso a posição fique entre dois elementos
            while ((current.next != this.head && iterator < position -1)) {
                current = current.next;
                iterator++;
            }
            
    
            newNode.next = current.next;
            current.next = newNode;
            this.length++;
            printList();
            return;
        }

    }



    public Type remove(int position){
        if(position > length -1) throw new RuntimeException("Posição não existe");
        
        
        
        if(position == 0){
            
            Node<Type> node = this.head;

            if(length == 1){
                this.head = null;
                this.length--;
                printList();
                return node.value;
            }

            Node<Type> tail = this.head;
            while (tail.next != this.head) {
                tail = tail.next;
            }
            
            tail.next = head.next;
            this.head = head.next;
            
            node.next = null;
            this.length--;
            printList();
            return node.value;
        }
        
        Node<Type> current = this.head;
        
        for(int index = 0; index < position - 1; index++){
            current = current.next;
        }

        Node<Type> node = current.next;
        current.next = node.next;
        node.next = null;
        printList();
        this.length--;
        return node.value;
    }

    public void printList() {
        Node<Type> current = this.head;

        if (this.head == null) {
            System.out.println("null");
            return;
        }
        // Percorre a lista e imprime no formato correto
        if(current.next == this.head){
            System.out.println("("+current.value+")");
        }
        else{
            while (current.next != this.head) {
                System.out.print("("+ current.value + ") -> ");
                current = current.next;
            }
            System.out.print("("+current.value+") -> " );
            System.out.println("Loop");
        }
    }

    public static void main(String[] args) {
        //java DataStruct/list/CircularLinkedList.java 
        CircularLinkedList<Integer> list = new CircularLinkedList<>();


        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 1);
        list.remove(0);
        list.remove(3);
        System.out.println("------------");
        list.add(5, 3);
        list.add(4, 0);

        System.out.println("------------");




    }

}
