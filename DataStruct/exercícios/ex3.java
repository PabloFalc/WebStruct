
class Node{
    public int value;
    public Node next;
    public Node prev;

    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}


public class ex3 {
    
    public Node head;
    public Node tail;
    public int length;

    public ex3(){
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


    public void add( int element, int position){
        
        if (position > this.length)throw new RuntimeException("Essa posição não existe");

        boolean isNearHead = isNearHeadOrTail(position);

        Node node = new Node(element);
        
        // se a largura for igual a zero, ou seja, lista vazia, ele insero o novo elemento
        if(length == 0){
            this.head = node;
            this.tail = node;
            
            this.head.next = this.tail;
            this.head.prev = this.tail;
            
            this.tail.next = this.head;
            this.tail.prev = this.head;
            this.length++;
            // printList();
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
            // printList();
            return;
        }
         
        // Faz a verificação de por onde o loop deve começar e ajusta a posição que ele deve andar
        Node current = isNearHead ? this.head : this.tail;
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
        // printList();
        return;
    }
    
    public Node remove(int position){
        
        
        if(this.length == 0) throw new IllegalArgumentException("a lista está vazia");
        else if (position > length) throw new IllegalArgumentException("Posição para a remoção não existe");
        
       
        // verifica se está perto da head ou da tail
        boolean isNearHead = isNearHeadOrTail(position);
        
        // Faz a verificação de por onde o loop deve começar e ajusta a posição que ele deve andar
        Node current = isNearHead ? this.head : this.tail;
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
        Node current = this.head;

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


    private Node loop(int initPos){

        if(initPos < 0 || initPos > this.length)throw new RuntimeException("louco");


        Node current = isNearHeadOrTail(initPos) ? this.head : this.tail;
        int position = isNearHeadOrTail(initPos) ? initPos : length - (initPos +1);


        for(int i = 0; i < position ; i++ ) {
            current = isNearHeadOrTail(initPos) ? current.next : current.prev;
        }
      
        return current;
        



    }
        

    public void move(int start, int end){

        
        Node startNode = loop(start);
        Node endNode = loop(end);


        if(endNode == this.tail && startNode == this.head ){
            System.out.println("fila ordenada");
            return;
        }
     
        
        // isolando a linha
        startNode.prev.next = endNode.next;
        endNode.next.prev = startNode.prev;
        if(endNode == this.tail){
            this.tail = this.head.prev;
        }
        else if(startNode == this.head){
            this.head = this.tail.next;
        }
        // conectando o nó inicial com a tail
        startNode.prev = this.tail;
        this.tail.next = startNode;

        // conectando o nó final com a head
        endNode.next = this.head;
        this.head.prev = endNode;

        printList();
        System.out.println("--------------------------------------------");



    }


    public static void main(String[] args) {
        ex3 list = new ex3();
        // Teste 1: Mover um segmento inicial (0 a 2) para o final
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(5, 4);
        System.out.println("\n=== Teste 1: Mover (0,2) para o final ===");
        list.move(0, 2); // Esperado: (4) <-> (5) <-> (1) <-> (2) <-> (3) <-> Loop

        // Teste 2: Mover um segmento do meio (1 a 3) para o final
        list = new ex3();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(5, 4);
        System.out.println("\n=== Teste 2: Mover (1,3) para o final ===");
        list.move(1, 3); // Esperado: (1) <-> (5) <-> (2) <-> (3) <-> (4) <-> Loop

        // Teste 3: Mover um único nó (2,2) para o final
        list = new ex3();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(5, 4);
        System.out.println("\n=== Teste 3: Mover (2,2) para o final ===");
        list.move(2, 2); // Esperado: (1) <-> (2) <-> (4) <-> (5) <-> (3) <-> Loop

        // Teste 4: Mover um segmento que já está no final (3,4)
        list = new ex3();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(5, 4);
        System.out.println("\n=== Teste 4: Mover (3,4) para o final ===");
        list.move(3, 4); // Esperado: (1) <-> (2) <-> (3) <-> (4) <-> (5) <-> Loop (sem mudanças)

        // Teste 5: Mover a lista inteira (0,4)
        list = new ex3();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        list.add(5, 4);
        System.out.println("\n=== Teste 5: Mover (0,4) para o final ===");
        list.move(0, 4); // Esperado: (1) <-> (2) <-> (3) <-> (4) <-> (5) <-> Loop (sem mudanças)

        // Teste 6: Tentar mover posições inválidas
        list = new ex3();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        System.out.println("\n=== Teste 6: Mover (1,5) inválido ===");
        try {
            list.move(1, 5); // Deve lançar uma exceção
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println("\n=== Teste 6.1: Mover (-1,2) inválido ===");
        try {
            list.move(-1, 2); // Deve lançar uma exceção
        } catch (RuntimeException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

    }
}

