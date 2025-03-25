
class Player{
    String name;
    int points;

    Player(String name){
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public void removePoints(int points){
        this.points = (this.points <= points) ? 0 : this.points - points;  
    }
}



class Node{
    Player player;
    Node next;
    Node prev;


    Node (Player player){
        this.next = null;
        this.prev = null;
        this.player = player;
    }

    public int getPoints(){
        return this.player.points;
    }

    public String getName(){
        return this.player.name;
    }


    public void addPoints(int value){
        player.addPoints(value);
    }
    public void removePoints(int value){
        player.removePoints(value);
    }



}



//galeria da fama
public class ex4 {
    /*
        a implementação será por meio de fila, mas a abordagem sera diferente
        o jogador com maior pontuação estará na head, e o com menor pontuação será a tail
        Jogadores que apareceram na tabela -> 1 -> 10, totalizando 10 jogadores
    */
    Node head;
    Node tail;
    int length;
    
    ex4(){
        this.head = null;
        this.tail = null;
    }

    public void add(String name){
        Player newPlayer = new Player(name);
        Node newNode = new Node(newPlayer);
        // if(this.tail!= null){
        //     System.out.println("this.tail"+ this.tail.player.name);
        //     System.out.println("this.head"+ this.head.player.name);
        // }
        // else{
        //     System.out.println("fodase");
        // }

        if(length == 0){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            // System.out.println("-------------------");
            newNode.next = this.tail;
            this.tail.prev = newNode;
            this.tail = newNode;
            // System.out.println(this.head.prev.player.name);
        }
        length++;
        // System.out.println("this.head 2: " +this.head.player.name);
        // System.out.println("this.TAIL 2: " +this.tail.player.name);
    }

    public Node search(String name){
        Node current = this.tail;
        while (current.next != null) {
            if(current.getName() == name){
                break;
            }
            current = current.next;
        }
        if(current == this.head && current.getName() != name){
            return null;
        }
        else{
            return current;
        }

    }

    public void removePoints(int value, String name){

        Node node = search(name);
        if(node == null){
            System.out.println("não encontado");
            return;
        }
        else{
            node.removePoints(value);
            if(node.getPoints() < node.prev.getPoints()){

                Node current = node.prev;
                while (node.getPoints() < current.prev.getPoints()|| current != this.tail){
                    current = current.prev;
                }

                if(node == this.head){
                    this.head = this.head.prev;
                    this.head.next = null;
                }
                else{
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }

                if(current == this.tail){
                    node.prev = null;
                    node.next = this.tail;
                }
                
                else{
                    node.prev = current.prev;
                    node.next = current;
                }
                current.prev = node;
                node.prev.next = node;
            }
            printQueue();

        }

    }

    public void addPoints(int value, String name){


        Node node = search(name);

        if(node == null){
            System.out.println("não encontrado");
            return;
        }
        node.addPoints(value);

        if(this.head == node){
            return;
        }


        if(node.getPoints() > node.next.getPoints()){
            Node current = node;
            while (node.getPoints() > current.getPoints()|| current!= this.head) {
                current = current.next;
            }
            if(node == this.tail){
                node.next.prev = null;
                this.tail = node.next;
                node.next = null;
            }
            else{      
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = null;
                node.next = null;
            }

            if(current == this.head && node.getPoints() > head.getPoints()){
                this.head.next = node;
                node.prev = this.head;
                this.head = node;
            }
            else{
                node.next = current.next;
                node.prev = current;
                current.next.prev = node;
                current.next = current;
            }
        }




    }



    public void printQueue() {
        Node current = this.tail;

        if (this.head == null) {
            System.out.println("null");
            return;
        }

        // Percorre a lista e imprime no formato correto
        while (current != null) {
            System.out.print("(" + current.player.name + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }

    public static void main(String[] args){

        ex4 fila = new ex4();


        fila.add("Joao");
        fila.printQueue();
        fila.add("Pedro");
        fila.printQueue();
        fila.add("Po");
        fila.printQueue();
        fila.addPoints(10,"Po");
        fila.printQueue();
        // fila.add("Joao");


    }

}
