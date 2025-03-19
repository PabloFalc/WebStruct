package tree;

import javax.management.RuntimeErrorException;

public class Tree<Type extends Comparable> {

    public Node<Type> root;
    

    public Tree (){
        this.root = null;
    }


    public insert(Type element){

        if (element == null) {
            throw new RuntimeException("elemento nulo");
        }


        Node<Type> node = new Node<>(element); 
        Node<Type> current = this.root;
        if(this.root == null){
            this.root = node;
        }

        while(true){    
            // se o node for menor que o valor
            if(node.value.compareTo(current.value) ==  -1 ){
                if(current.left == null){
                    current.left = node;
                    break;
                }
                else{
                    current = current.left;
                }
            }// node.value > current.value
            else{
                if(current.rigth == null){
                    current.rigth = node;
                    break;
                }
                else{
                    current = current.rigth;
                }
            }
        }
    }

    /*
    in-Order -> vai descendo pela esquerda até o final, dps vai pra direita, sobe e vai pra esquerda

    pre-Order ->


    */

    public Type inOrder(){
        Node<Type> current = this.root;

        


    }

    public Type delete(Type element){

        if(this.root == null){
            throw new RuntimeException("A árvore está nula");
        }
    }



    public int countNodes(){
        // retorna o número total de nós da arvore
    }

    public int height(Type element){
        // altura de um nó até o outro
    }

    public Type seach(Type element){
        /*
            Se o valor for menor que o nó atual, a busca continua na subárvore esquerda.
            Se o valor for maior que o nó atual, a busca continua na subárvore direita.
            Se o valor for igual ao nó atual, significa que encontramos o valor.
         */
    }




}