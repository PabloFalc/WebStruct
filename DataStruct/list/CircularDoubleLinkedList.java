package list;

class Node<Type>{
    public Type value;
    public Node<Type> next;
    public Node<Type> prev;

    public Node(Type value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class CircularDoubleLinkedList<Type>{
    
    public Node<Type> head;
    public Node<Type> tail;
    public int length;

    public CircularDoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    private boolean isNearHeadOrTail(int position){
        /*
            verifica se a posição é menor que a metade da largura da lista -1

            true: então deve começar pela head, a distância até a posição será menor
            false: então deve começar pela tail, a distância até a posição será menor
         */
        return (position <= (this.length -1) /2) ? true : false;

    } 


    public void add( Type element, int position){
        
        if (element == null) throw new IllegalArgumentException("elemento add nulo");
        else if (position > this.length)throw new RuntimeException("Essa posição não existe");

        boolean isNearHead = isNearHeadOrTail(position);

        Node<Type> node = new Node<>(element);
        
        // se a largura for igual a zero, ou seja, lista vazia, ele insero o novo elemento
        if(length == 0){
            this.head = node;
            this.tail = node;
            
            this.head.next = this.tail;
            this.head.prev = this.tail;
            
            this.tail.next = this.head;
            this.tail.prev = this.head;
            this.length++;
            printList();
            return;
        }

        // Caso o novo elemento seja add na última posição
        if(position == length){
            node.next = this.head;
            node.prev = this.tail;
            this.head.prev = node;
            this.tail.next = node;
            this.tail = node;
            this.length++;
            printList();
            return;
        }
         
        // Faz a verificação de por onde o loop deve começar e ajusta a posição que ele deve andar
        Node<Type> current = isNearHead ? this.head : this.tail;
        int indexPosition = isNearHead ? position : this.length - (position+1);
        
        
        for (int i = 0; i < indexPosition; i++){
            //  .next caso comece pela head || .prev caso comece pela tail
            current = isNearHead ? current.next : current.prev;
        }
        

        // operação de inserção entre dois elementos != this.tail
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;

        // caso o novo elemento seja add na posição 0 -> head
        if(current == this.head){
            this.head = node;
            this.tail = node.prev;
        }
        this.length++;
        printList();
        return;
    }
    
    public Node<Type> remove(int position){
        
        
        if(this.length == 0) throw new IllegalArgumentException("a lista está vazia");
        else if (position > length) throw new IllegalArgumentException("Posição para a remoção não existe");
        
       
        // verifica se está perto da head ou da tail
        boolean isNearHead = isNearHeadOrTail(position);
        
        // Faz a verificação de por onde o loop deve começar e ajusta a posição que ele deve andar
        Node<Type> current = isNearHead ? this.head : this.tail;
        if(this.length == 1){
            
            current.next = null;
            current.prev = null;

            this.head = null;
            this.tail = null;
           
            this.length--;
            printList();
            return current;
        }
        int indexPosition = isNearHead ? position : this.length - (position+1);

        for(int i = 0; i< indexPosition; i++){
            current  = isNearHead ? current.next : current.prev;
        }

        
        // operação de del entre dois elementos
        current.prev.next = current.next;
        current.next.prev = current.prev;

        // att a tail ou head, caso o elemento removido seja um deles
        if(current == this.tail || current == this.head){
            this.tail = current.prev;
            this.head = current.next;
        }


        //isola o elemento para dar return
        current.prev = null;
        current.next = null;
        this.length--;
        printList();

        return current;

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
                System.out.print("("+ current.value + ") <-> ");
                current = current.next;
            }
            System.out.print("("+current.value+") <-> " );
            System.out.println("Loop");
        }
    }
   
    


    public static void main(String[] args) {
        CircularDoubleLinkedList<Integer> list = new CircularDoubleLinkedList<>();
        //java DataStruct/list/CircularDoubleLinkedList.java
        list.add(1, 0);
        list.add(2, 1);
        list.add(4, 2);
        list.add(5, 0);
        list.add(3, 3);
        System.out.println("------");
        list.remove(0);
        list.remove(3);
        list.remove(1);
        list.remove(0);
        // list.add(3, 0);

    }
}
