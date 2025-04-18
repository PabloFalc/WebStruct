package list;


class Node <Type> {

    Type value;
    Node<Type> next;
    Node<Type> prev;
    

    public Node(Type value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}


public class DoubleLinkedList<Type> {

    public Node<Type> head;
    public int length;


    public DoubleLinkedList(){
        this.head = null;
        this.length = 0;
    }


    public void add(Type element,int position){
        Node<Type> newNode = new Node<>(element);

        // caso a lista esteja vazia
        if(this.length == 0){
            this.head = newNode;
            this.length++;
            printList();
            return;
        }
        else if( position > length){
            throw new NullPointerException("posição inválida");
        }

        Node<Type> current = this.head;
        int itarator = 0;

        
        while (current.next!= null && itarator < position) {
            current = current.next;
            itarator++;
        }

        if (position <= 0){
            current.prev = newNode;
            newNode.next = current;
            this.head = newNode;
            this.length++;
            printList();
            return;
        }
        // caso o elemento queira ser add no final da lista
        else if(position == this.length){
            current.next = newNode;
            newNode.prev = current;
            this.length++;
            printList();
            return;
        }
        
        // pra add em uma posição entre outros dois elementos
        newNode.next = current;
        newNode.prev = current.prev;
        
        current.prev.next = newNode;
        current.prev = newNode;
        this.length++;
        printList();
        return;
        
    }

    
    public void removeByElement(){
        // nothing here
        return;
    }
    
    public Type removeByPosition(int position){
        
        // operação de remoção com lista vazia
        if(this.length == 0)throw new NullPointerException("lista vazia");
        Node<Type> node = this.head;
        
        // caso a lista tenha somente um elemento
        if (this.length == 1) { 
            
            this.head = null;
            this.length--;
            printList();
            return node.value;
        }
        
        // caso a posição removida seja a head
        if (position == 0) {
            this.head = node.next;
            this.head.prev = null;
            node.next = null;
            this.length--;
            printList();
            return node.value;
            
        }
        
        int iterator = 0;
        
        
        
        
        while (node.next!=null &&  iterator < position) {
            node = node.next;
            iterator++;
        }
        
        
        
        
        // caso seja o último elemento da lista
        if(node.next == null){
            node.prev.next = null;
            node.prev = null;
            this.length--;
            printList();
            return node.value;
        }
        // caso o elemento esteja entre dois outros elementos 
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        printList();
        return node.value;
    }
    
    public void printList() {
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

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        //java DataStruct/list/DoubleLinkedList.java

        list.add(2, 0);
        list.add(3, 1);
        list.add(1, 2);
        list.add(10, 2);
        list.add(15, 2);
        list.add(20, 2);
        list.add(70, 2);
        list.add(4, 0);
        list.add(10, 3);
        System.out.println("------------");
        Integer element = list.removeByPosition(7);
        System.out.println(element);
        element = list.removeByPosition(7);
        System.out.println(element);
        element = list.removeByPosition(0);
        System.out.println(element);
        element = list.removeByPosition(2);
        System.out.println(element);

    }
}