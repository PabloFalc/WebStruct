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
            if(current.value.compareTo(element) > 0){
                if(current.left == null){
                    current.left = node;
                    break;
                }
                else{
                    current = current.left;
                }
            }// node.value > current.value
            else{
                if(current.right == null){
                    current.right = node;
                    break;
                }
                else{
                    current = current.right;
                }
            }
        }
    }
    
    public Type delete(Type element){
     
        if(this.root == null){
            throw new RuntimeException("A árvore está nula");
        }
    
        System.out.println("Removed element: "+ element);
        Node<Type> currentParent = null;
        Node<Type> current = this.root;

        while (current!=null) {
            // break pra parar a busca
            if(current.value.equals(element)){
                break;  
            }
            // caso o elemento seja menor que o atual
            else if(element.compareTo(current.value) > 0){
                currentParent = current;
                current = current.right;
            }
            // caso o elemento seja maior que o atual;
            else{
                currentParent = current;
                current = current.left;
            }
            
        }
        if(current == null){
            System.out.println("elemento não encontrado");
            return null;
        }
       



        // o atual tem filhos a direita
        if (current.right != null){
            System.out.println("caiu no current.right");
            System.out.println("this.root.right" + current.right.value);
            System.out.println("----------");
            
            Node<Type> replacement = current.right;
            Node<Type> replacementParent = current;
            System.out.println("replecenment antes do loop: " + replacement.value);
            System.out.println("replecenmentPArent antes do loop: " + replacementParent.value);
            System.out.println("!!!!!!!!!!!!!!!!!!!");
            
            
            while (replacement.left != null) {
                System.out.println("++++++++++++++++++++++++++");
                replacementParent = replacement;
                replacement = replacement.left; 
                
                System.out.println("replecement loop: "+ replacement.value);
                System.out.println("replecementPAi loop: "+ replacementParent.value);
            }
            System.out.println("replecement.parent.left "+ replacementParent.left.value);
            // garantir que o replacementParent vai se desconectar de replacement
            if(replacement.value.compareTo(replacementParent.value) < 1){
                replacementParent.left = null;
            }
            else{
                replacementParent.right = null;
            }

            if(currentParent != null){
                if (currentParent.value.compareTo(current.value) > 0) {
                    replacement.left = current.left;
                    replacement.right = current.right;
                    currentParent.left = replacement;
                }
                else{
                    currentParent.right = replacement;
                }
            }// caso o removido seja a raiz
            else{
                System.out.println("current Parent deu null");
                System.out.println(current.left.value);
                replacement.left = current.left;
                replacement.right = current.right;

                // System.out.println(replacement.right.value);
                this.root = replacement;
            }
            
        }
        // o atual tem filhos a esquerda
        else if(current.left != null){
            System.out.println("caiu no current.left");

            Node<Type> replacement = current.left;
            Node<Type> replacementParent = current;
            System.out.println("replecenment antes do loop: " + replacement.value);
            System.out.println("replecenmentPArent antes do loop: " + replacementParent.value);
            
            
            
            while (replacement.right != null) {
                replacementParent = replacement;
                replacement = replacement.right;  
                System.out.println("replecement loop: "+ replacement.value);
                System.out.println("replecementPAi loop: "+ replacementParent.value);
            }
            System.out.println("replecement.parent.left "+ replacementParent.left.value);
            //garantir que o o replacementPArent remova as ligações com replacemnet
            if(replacement.value.compareTo(replacementParent.value) < 1){
                replacementParent.left = null;
            }
            else{
                replacementParent.right = null;
            }

            if(currentParent != null){   
                if (currentParent.value.compareTo(current.value) > 0) {
                    replacement.left = current.left;
                    replacement.right = current.right;
                    currentParent.left = replacement;
                    return current.value;
                }
                else{
                    replacement.left = current.left;
                    replacement.right = current.right;
                    currentParent.right = replacement;
                    return current.value;
                }     
            }// caso o removido seja raiz
            else{
                replacement.left = current.left;
                replacement.right = current.right;
                this.root =replacement;
            }

        }
        // o atual não tem filhos
        else{
            if(currentParent != null){
                System.out.println("não tem filhos");
                if(currentParent.value.compareTo(current.value) > 0){
                    currentParent.left = null;
                    return current.value;
                }
                else{
                    currentParent.right = null;
                }
            }
            else{
                this.root = null;
                System.out.println("elemento era raiz e foi removido");
            }
            
        }
        
        

        return current.value;
    }
  
    private void removeIfRoot(){
        if(hasRight(this.root)){
            Node<Type> repParent = null;
            Node<Type> replacement = this.root.right;
            
            while(hasLeft(replacement)){
                repParent = replacement;
                replacement = replacement.left;
            }

        }



    }

    private boolean hasLeft(Node<Type> node){
        return (node.left != null);
    }

    private boolean hasRight(Node<Type> node){
        return (node.right != null);
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
        // System.out.println("-------------------");
        // tree.delete(15);
        // tree.getInOrderStack();
        // System.out.println("-------------------");
        // tree.delete(18);
        // tree.getInOrderStack();
        // System.out.println("-------------------");
        tree.delete(20);
        tree.getInOrderStack();
        tree.delete(tree.root.value);
        tree.getInOrderStack();
        tree.delete(tree.root.value);
        tree.getInOrderStack();
        tree.delete(tree.root.value);
        tree.getInOrderStack();
        tree.delete(tree.root.value);
        tree.getInOrderStack();
        tree.delete(tree.root.value);
        tree.getInOrderStack();
    }

}