package stack;

public class Stack <Type>{

    Node<Type> head;
    private int length;

    public Stack(){
        this.head = null;
        this.length = 0;
    }

    public void push (Type element){

        Node<Type> node = new Node<Type>(element);
        if(isEmpty()){
            this.head = node;
            this.length++;
            printStack();
            return;
        }
        node.prev = this.head;
        this.head.next = node;
        this.head = node;
        this.length++;
        printStack();
        return;
    }

    public Node<Type> pop(){
        Node<Type> node = this.head;
        if(isEmpty()){
            throw new RuntimeException("Stack tá nula");
        }
        else if(size()== 1){
            this.head = null;
            this.length--;
            return node;
        }

        this.head = head.prev;
        this.head.next = null;
        node.prev = null;
        printStack();
        this.length--;
        return node;

    }

    public Type peek(){
        return isEmpty() ? null : this.head.value;
    }



    public boolean isEmpty(){
        return size() == 0 ? true : false; 
    }

    public int size(){
        return this.length;
    }

    public void printStack() {
        Node<Type> current = this.head;

        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        if(size() == 1){
            System.out.println("("+current.value+")");
            return;
        }
        // Percorre a lista e imprime no formato correto
        while (current != null) {
            System.out.print("("+ current.value + ") <-> ");
            current = current.prev;
        }
        System.out.println("null");  // Indica o final da lista
    }


    public static void main(String[] args){

        //java DataStruct/stack/Stack.java 
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("--------");
        
        System.out.println(stack.peek());
        stack.pop();
        System.out.println("peek: "+stack.peek());
        stack.pop();
        System.out.println("peek: "+stack.peek());
        stack.pop();
       
        



    }


}