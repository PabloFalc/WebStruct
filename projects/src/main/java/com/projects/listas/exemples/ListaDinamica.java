package com.projects.listas.exemples;

class No {
    int valor;
    No prox;

    public No(int valor) {
        this.valor = valor;
        this.prox = null;
    }
}
public class ListaDinamica {
    private No inicio;

    public ListaDinamica() {
        this.inicio = null;
    }

    public boolean add(int elemento, int p) {
        No novoNo = new No(elemento);
        
        if (p < 0) {
            return false;
        }

        if (p == 0) {
            novoNo.prox = inicio;
            inicio = novoNo;
            return true;
        }

        No atual = inicio;
        int i = 0;

        while (atual != null && i < p - 1) {
            atual = atual.prox;
            i++;
        }

        if (atual == null) {
            return false;
        }

        novoNo.prox = atual.prox;
        atual.prox = novoNo;
        return true;
    }

    public boolean remove(int p) {
        if (inicio == null || p < 0) {
            return false;
        }

        if (p == 0) {
            inicio = inicio.prox;
            return true;
        }

        No atual = inicio;
        int i = 0;

        while (atual.prox != null && i < p - 1) {
            atual = atual.prox;
            i++;
        }

        if (atual.prox == null) {
            return false;
        }

        atual.prox = atual.prox.prox;
        return true;
    }

    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaDinamica lista = new ListaDinamica();

        lista.add(5, 0);
        lista.add(10, 1);
        lista.add(15, 2);
        lista.add(20, 1);

        lista.imprimir();

        lista.remove(2);

        lista.imprimir();
    }
}
