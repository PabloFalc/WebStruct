package com.projects;

import com.projects.listas.lista_dinamica.DinamicList;

public class Main {
    public static void main(String[] args) {
        DinamicList list = new DinamicList();


        list.add(10,0);
        list.add(20,1);
        list.add(30,2);
        list.remove(0);

        list.add(15,0);
        list.search(10);

    }






}