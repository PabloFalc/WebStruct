package tree;

import stack.Stack;

public class Tree<Type extends Comparable<Type>> {

    public Node<Type> root;
    

    public Tree (){
        this.root = null;
    }


    public void insert(Type element){

        if (element == null) {
            throw new RuntimeException("elemento nulo");
        }

        
        Node<Type> node = new Node<>(element); 
        if(this.root == null){
            this.root = node;
        }
        Node<Type> current = this.root;

        while(true){    
            // se o node for menor que o valor
            if(current.value.compareTo(element) < 1){
                if(current.left == null){
                    current.left = node;
                    System.out.println("menor");
                    System.out.println("loop esqerdo");
                    break;
                }
                else{
                    System.out.println("loop esqerdo");
                    current = current.left;
                }
            }// node.value > current.value
            else{
                if(current.right == null){
                    current.right = node;
                    System.out.println("maior");
                    break;
                }
                else{
                    System.out.println("Loop direito");
                    current = current.right;
                }
            }
        }
    }

    /*
    in-Order -> vai descendo pela esquerda até o final, dps vai pra direita, sobe e vai pra esquerda

    pre-Order ->


    */

    
    public Type delete(Type element){
        
        if(this.root == null){
            throw new RuntimeException("A árvore está nula");
        }
        return element;
    }
  
    

    private void inOrder(Node <Type> current, Stack<Type> nodeStack){
        if (current == null) {
            return;
        }
        inOrder(current.left, nodeStack);
        nodeStack.push(current.value);
        inOrder(current.right, nodeStack);
    }

    public Stack<Type> getInOrderStack(){
        Stack<Type> nodeStack = new Stack<>();
        inOrder(this.root, nodeStack);
        nodeStack.printStack();
        return nodeStack;
    }
    

    private void preOrder(Node <Type> current, Stack<Type> nodeStack){

        if(current == null){
            return;
        }
        nodeStack.push(current.value);
        preOrder(current.left, nodeStack);
        preOrder(current.right, nodeStack);
    }

    public Stack<Type> getPreOrderStack(){
        Stack<Type> nodeStack = new Stack<>();
        preOrder(this.root, nodeStack);
        nodeStack.printStack();
        return nodeStack;
    }
    

    private void posOrder(Node <Type> current, Stack<Type> nodeStack){

        if(current == null){
            return;
        }
        posOrder(current.left, nodeStack);
        posOrder(current.right, nodeStack);
        nodeStack.push(current.value);
    }

    public Stack<Type> getPosOrderStack(){
        Stack<Type> nodeStack = new Stack<>();
        posOrder(this.root, nodeStack);
        nodeStack.printStack();
        return nodeStack;
    }
    


    public int countNodes(){
       return 0;
    }

    public int height(Type element){
        
        return 0;
    }

    public Type seach(Type element){
        Node<Type> node = new Node<>(element);
        Node<Type> current = this.root;

        while(true){
            if(current == null){
                return null;
            }
            
            if(current.value.compareTo(node.value) == 1){
                current = current.left;
            }
            else if(current.value.compareTo(node.value) == -1){
                current = current.right;
            }
            break;
        }



        return element;
    }


    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.insert(20);
        tree.insert(15);
        tree.insert(18);
        // tree.insert(10);
        // tree.insert(7);
        // tree.insert(11);
        // tree.insert(30);
        // tree.insert(25);
        // tree.insert(31);
        tree.getInOrderStack();
    }

}