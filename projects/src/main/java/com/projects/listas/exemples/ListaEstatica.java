package com.projects.listas.exemples;

public class ListaEstatica {
    private int[] valor;
    private int ultimo;
    private int tamanho;

    public ListaEstatica(int P) {
        this.tamanho = P;
        this.valor = new int[P];
        this.ultimo = -1; 
    }

    public boolean add(int elemento, int p) {
        if (p < 0 || p > ultimo + 1 || ultimo + 1 >= tamanho) {
            return false; 
        }

        for (int i = ultimo; i >= p; i--) {
            valor[i + 1] = valor[i];
        }

        valor[p] = elemento;
        ultimo++;
        return true;
    }

    public boolean remove(int p) {
        if (p < 0 || p > ultimo) {
            return false; 
        }

        for (int i = p; i < ultimo; i++) {
            valor[i] = valor[i + 1];
        }

        ultimo--;
        return true;
    }

    public void imprimir() {
        for (int i = 0; i <= ultimo; i++) {
            System.out.print(valor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(10);
        
        lista.add(5, 0);
        lista.add(10, 1);
        lista.add(15, 2);
        lista.add(20, 1);
        
        lista.imprimir(); 

        lista.remove(2); 
        
        lista.imprimir();
    }
}
