class Node<Type> {
    public Type value;
    public Node<Type> next;
    
    public Node(Type value){
        this.value = value;
        this.next = null;
    }
}


public class ex1<Type> {
    public Node<Type> head;

    public ex1(){
        this.head = null;
    }

    public boolean add(Type value, int position) {
     
        Node<Type> newNode = new Node<>(value);

        if (position < 0){
            return false;
        }

        if (position == 0){
            newNode.next = head;
            head = newNode;
            return true;
        }

        Node<Type> actual = head;
        int iterator = 0;

        while (actual != null && iterator < position - 1) {
            actual = actual.next;
            iterator++;
        }

        if (actual == null){
            return false;
        }

        newNode.next = actual.next;
        actual.next = newNode;
        return true;
    }

    public boolean remove(int position) {
        if (position < 0 || head == null){
            return false;
        }

        if (position == 0){
            head = head.next;
            return true;
        }

        Node<Type> actualNode = head;
        int iterator = 0;

        while (actualNode.next != null && iterator < position - 1) {
            actualNode = actualNode.next;
            iterator++;
        }

        if (actualNode.next == null){
            return false;
        }

        actualNode.next = actualNode.next.next;
        return true;
    }

    public Type search(Type value) {
        Node<Type> actualNode = this.head;
        int i = 0;
        while (actualNode != null) {
            if (actualNode.value == value) {
                System.out.println("valor encontrado: " + actualNode.value + " index: " + i);
                return actualNode.value;
            }

            actualNode = actualNode.next;
            i++;
        }
        System.out.println("não encontrado");
        return null;
    }

    public void printList() {
        Node<Type> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }


    // Método mais confiável, separa os paras em uma mini lista e depois liga ela com a lista principal
    public void move(){
        

        Node<Type> current = head;
        Node<Type> currentParent = null;
        Node<Type> firstPair = null, lastPair = null;


        while(current != null){

            if(isPair(current)){
                if (firstPair == null && current == this.head) {
                    this.head = this.head.next;
                    firstPair = current;
                    lastPair = current;
                    current = this.head;
                }
                else{
                    if(current.next == null){
                        break;
                    }
                    else if(firstPair == null){
                        firstPair = current;
                        lastPair = current;
                    }
                }
                currentParent.next = current.next;
                current.next = null;
                lastPair.next = current;
                lastPair = current; 
                current = currentParent.next;          
            }
            else{
                currentParent = current;
                current = current.next;
            }

        }
        if(firstPair != null){
            currentParent.next = firstPair;
        }
        
    }


    private boolean isOdd(Node<Type> node){
        return (Integer) node.value %2 != 0 ? true : false;
    }
    
    private boolean isPair(Node<Type> node){
        return ((Integer)node.value %2 == 0 ) ? true : false;
    }


    // metódo um pouco bugado, define um braking point e leva os impares para a esquerda, automáticamente separa os pares pra direita
    public void pairOrder(){
        if (this.head == null || this.head.next == null) throw new RuntimeException("lista vazia");

        Node<Type> breakingPoint = this.head;
        Node<Type> current = this.head;
        Node<Type> currentParent = null;

        System.out.println("currentvalue next: "+current.next.value);


        while(current != null){
            
            if(isOdd(current)){
                if(!isOdd(this.head)){
                    System.out.println("cai aqui");
                    currentParent.next = current.next;
                    current.next = this.head;
                    this.head = current;
                    breakingPoint = this.head;
               }
               else if(current == this.head){
                    currentParent = current;
               }
               else{
                    System.out.println("valor current"+current.value);
                    System.out.println("this.head"+head.value);
                    currentParent.next = current.next;
                    current.next = breakingPoint.next;
                    breakingPoint.next = current;
                    breakingPoint = current;
               }
               current = currentParent.next;
            }
            else{
                currentParent = current;
                current = current.next;
            }
        }
        // current.next = firstPair;
        // printList();
    }



    
    public static void main(String[] argumentos) {
        ex1<Integer> list = new ex1<>();

        //       java DataStruct/exercícios/ex1.java

        // list.move();
        list.move();
        list.add(1, 0);
        list.add(0, 1);
        list.add(2, 2);
        
        list.add(4, 3);
        list.add(9, 4);
        list.add(25, 5);
        list.add(12, 6);
        
        list.add(20, 7);
        list.add(15, 8);
        list.printList();
        System.out.println("------Depois da ordem---------");
        list.move();
        list.printList();
        list.add(150, 2);
        list.printList();
        list.move();
        list.printList();
        list.move();
        list.printList();
        list.move();
        
        
    }
}
