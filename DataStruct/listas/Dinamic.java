package listas;

class Node {
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

class DinamicList {
    public Node start;

    public DinamicList(){
        this.start = null;
    }

    public boolean add(int value, int position) {
        if (value == 0) {  // Verificação para valor inválido
            return false;
        }

        Node newNode = new Node(value);

        if (position < 0){
            return false;
        }

        if (position == 0){
            newNode.next = start;
            start = newNode;
            return true;
        }

        Node actual = start;
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
        if (position < 0 || start == null){
            return false;
        }

        if (position == 0){
            start = start.next;
            if (start != null) {
                System.out.println(start.value + " " + start.next.value);
            } else {
                System.out.println("A lista está vazia após remoção.");
            }
            return true;
        }

        Node actualNode = start;
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

    public Node search(int value) {
        Node actualNode = start;
        int i = 0;
        while (actualNode != null) {
            if (actualNode.value == value) {
                System.out.println("valor encontrado: " + actualNode.value + " index: " + i);
                return actualNode;
            }

            actualNode = actualNode.next;
            i++;
        }
        System.out.println("não encontrado");
        return null;
    }

    public void printList() {
        Node current = start;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Dinamic {
    public static void main(String[] argumentos) {
        DinamicList list = new DinamicList();

        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.printList();  // Imprime a lista após as adições

        list.remove(1);    // Remove o nó na posição 1
        list.printList();  // Imprime a lista após a remoção
    }
}
