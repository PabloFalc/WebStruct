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
            return;
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
        /*
        casos:

        não tem filho
        tem filho so de um lado
        tem filho dos dois lados




         */
        if(this.root == null){
            throw new RuntimeException("A árvore está nula");
        }

        Node<Type> current = this.root;
        Node<Type> currentParent = null;

        while (current!=null) {
            // break pra parar a busca
            if(current.value.equals(element)){
              break;  
            }
            // caso o elemento seja menor que o atual
            else if(current.value.compareTo(element) < 1){
                currentParent = current;
                current = current.left;
            }
            // caso o elemento seja maior que o atual;
            else{
                currentParent = current;
                current = current.right;
            }
            
        }
        // o atual tem  fihlos em ambos os lados
        if (current.left != null && current.right != null) {
            
        }
        // o atual tem filhos a esquerda
        else if(current.left != null){

        }
        // o atual tem filhos a direita
        else if (current.right != null){

            Node<Type> replacement = current.right;
            Node<Type> replacementParent = current;


            while (replacement.left != null) {
                replacementParent = replacement;
                replacement = replacement.left;  
            }


            if(replacement.value.compareTo(replacementParent.value) < 1){
                replacementParent.left = null;
            }
            else{
                replacement.right = null;
            }
            
            if (currentParent.value.compareTo(current.value) < 1) {
                currentParent.left = replacement;
            }
            else{
                currentParent.right = replacement;
            }
            
        }
        // o atual não tem filhos
        else{
            if(currentParent.value.compareTo(element) < 1){
                currentParent.left = null;
                return current.value;
            }
            else{
                currentParent.right = null;
                return current.value;
            }

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
    

    private void postOrder(Node <Type> current, Stack<Type> nodeStack){

        if(current == null){
            return;
        }
        postOrder(current.left, nodeStack);
        postOrder(current.right, nodeStack);
        nodeStack.push(current.value);
    }

    public Stack<Type> getPostOrderStack(){
        Stack<Type> nodeStack = new Stack<>();
        postOrder(this.root, nodeStack);
        nodeStack.printStack();
        return nodeStack;
    }
    


    public int height(Type element){
        Node<Type> current = this.root;
        int count = 0 ;
        while (current != null) {
            if(current.value.compareTo(element) == 0){
                break;
            }

            if (current.value.compareTo(element) < 1) {
                current = current.left;
                count++;
            }
            else{
                current = current.right;
                count++;
            }

        }
        return count;
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

        // java DataStruct/tree/Tree.java 
        tree.insert(20);
        tree.insert(15);
        tree.insert(18);
        tree.insert(10);
        tree.insert(7);
        tree.insert(11);
        tree.insert(30);
        tree.insert(25);
        tree.insert(31);
        System.out.println("------IN---------");
        tree.getInOrderStack();
        System.out.println("-------Pre--------");
        tree.getPreOrderStack();
        System.out.println("-------Post--------");
        tree.getPostOrderStack();

        System.out.println(tree.height(11));
    }

}