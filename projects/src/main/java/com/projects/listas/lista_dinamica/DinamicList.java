package com.projects.listas.lista_dinamica;

public class DinamicList {
    public Node start;

    public DinamicList(){
        this.start = null;
    }

    /*
        CONDIÇÕES PARA ADD UM NOVO NÓ

        Node != Null
        Position != Null => em caso de tipos não primitivos
        Position !< 0
     */

    public boolean add(int value, int position){
        Node newNode = new Node(value);


        // Garantindo que a posição acessada não seja negativa
        if(position < 0){
            return false;
        }
        

        // Garantindo a segurança caso o novo elemento vire o primeiro
        if(position == 0){
            newNode.next = start; // o next pega o valor do elemento inicial
            start = newNode; // o elemento inical pega o valor do novo elemento
        }

        Node actual = start;
        int iterator = 0;

        // quero parar na posição anterior a que eu quero add o novo item;
        while (actual != null && iterator < position - 1) { 
            actual = actual.next;
            iterator++;
        }
        // se ele botar em uma posição não existente
        if(actual == null){
            return false;
        }

        newNode.next = actual.next;
        actual.next = newNode;
        return true;
    }

    /*
        CONDIÇÕES PARA REMOVER O NODE

        Position != 0
        Position != null => em caso de tipos não primitivos
        start != null
    */

    public boolean remove(int position){
        if(position < 0 || start !=null){
            return false;
        }

        // remover a posição inicial
        if(position == 0){
            start = start.next;
            return true;
        }

        Node actualNode = start;
        int iterator = 0;

        // (actualNode.next != null) serve para evitar iterações desnecessários

        while (actualNode.next != null && iterator < position - 1 ) {
            actualNode = actualNode.next;
            iterator++;
        }

        // caso a posição nao exista
        if(actualNode.next == null){
            return false;
        }

        actualNode.next = actualNode.next.next;

        return true;
    }


    public Node search(int value){
        
        Node actualNode = start;
        int i =0 ;
        while(actualNode!=null){


            if(actualNode.value == value){
                System.out.println(actualNode.value +" i: "+ i);
                return actualNode;

            }
            actualNode = actualNode.next;
            i++;

        }
        return null;

    }


}
