package list;

class Node<Type> {
    public Type value;
    public Node<Type> next;

    public Node(Type value){
        this.value = value;
        this.next = null;
    }
}

public class DinamicList <Type> {
    public Node<Type> head;

    public DinamicList(){
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

    public void move(){
        

        Node<Type> current = head;
        Node<Type> currentParent = null;
        Node<Type> firstPair = null, lastPair = null;


        while(current!= null){
            if(paridade(current)){
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

                    currentParent.next = current.next;
                    current.next = null;
                    lastPair.next = current;
                    lastPair = current; 
                    current = currentParent.next;
                }

            }
            else{
                currentParent = current;
                current = current.next;
            }
        }
        current.next = firstPair;
        printList();
    }




    private boolean paridade(Node<Type> node){
        return ((Integer)node.value %2 == 0 ) ? true : false;
    }
    
    public static void main(String[] argumentos) {
        DinamicList<Integer> list = new DinamicList<>();

        //java DataStruct/list/DinamicList.java

        list.add(2, 0);
        list.add(1, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(9, 4);
        list.add(6, 5);
        list.add(10, 6);
        list.add(15, 7);
        list.add(20, 8);
        list.add(40, 2);
        list.add(42, 9);
        list.add(44, 10);
        // list.move();
        list.move();
        
    }
}
