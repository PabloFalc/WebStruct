
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
        this.points = (this.points <= points) ? 0 : this.points-points;  
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


        if(length == 0){
            this.head = newNode;
            this.tail = newNode;
        }
        else{

            newNode.next = this.tail;
            this.tail.prev = newNode;
            this.tail = newNode;
        }
        length++;

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
 
        node.removePoints(value);
        if(node == this.tail){
           
        }

        else if(node.getPoints() < node.prev.getPoints()){

            Node current = node;
            System.out.println(current.prev.getName());
            while (current.prev != null && node.getPoints() < current.prev.getPoints()){
                System.out.println("curernt: " +current.getName());
                current = current.prev;
            }
            if(node == this.head){
                this.head = node.prev;
                node.prev = null;
                this.head.next = null;
            }
            else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } 
            if(current == this.tail){
                node.prev = null;
                node.next = this.tail;
                this.tail.prev = node;
                this.tail = node;
            }
            
            else{
                node.prev = current.prev;
                node.next = current;
                current.prev = node;
                node.prev.next = node;
            }
        }
        printQueue();
    }

    public void addPoints(int value, String name){


        Node node = search(name);

        if(node == null){
            System.out.println("não encontrado");
            return;
        }

        node.addPoints(value);
        if(node == this.head){
        }
        else if(node.getPoints() > node.next.getPoints()){
            Node current = node;
            while (current.next != null && node.getPoints() > current.next.getPoints()) {
         
                
                current = current.next;
            }
      
      
            if(node == this.tail){

                node.next.prev = null;
                this.tail = node.next;
                node.next = null;
            }else{
          
                node.prev.next =  node.next;
                node.next.prev = node.prev;
            }
            if(current==this.head){
    
                node.prev = this.head;
                this.head.next = node;
                node.next = null;
                this.head = node;
            }
            else{
                node.next = current.next;
                node.prev = current;
                current.next = node;
                node.next.prev = node;
            }
      
        }
        else{ 
        }
        printQueue();


    }



    public void printQueue() {
        Node current = this.tail;

        if (this.head == null) {
            System.out.println("null");
            return;
        }

        // Percorre a lista e imprime no formato correto
        while (current != null) {
            System.out.print("( ["+current.getPoints()+"] " + current.getName() + ") -> ");
            current = current.next;
        }
        System.out.println("null");  // Indica o final da lista
    }

    public static void main(String[] args){
        //                  java DataStruct/exercícios/ex4.java 
        ex4 fila = new ex4();


        fila.add("Kendrick");
        fila.add("Travis");
        fila.add("Kratos");
        fila.add("Hollow");
        fila.printQueue();
        fila.addPoints(10,"Kratos");
        fila.addPoints(5, "Hollow");
        fila.addPoints(7, "Kendrick");
        fila.addPoints(1, "Travis");
        fila.addPoints(10, "Kratos");
      
        System.out.println("antes de remover");
        System.out.println("");
        
        fila.removePoints(14, "Kratos");
        fila.removePoints(5, "Hollow");
        fila.removePoints(7, "Kendrick");
        

    }

}
