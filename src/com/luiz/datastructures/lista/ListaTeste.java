package com.luiz.datastructures.lista;

public class ListaTeste {
    public static void main(String[] args) {
        var lista = new ListaEncadeada<Integer>();
        
        lista.adiciona(1);
        lista.adiciona(2);
        lista.adiciona(3);
        lista.adiciona(4);
        // [1, 2, 3, 4, 5]
        lista.adiciona(4, 5);
       
        System.out.println(lista.removeIndex(0));
        System.out.println(lista);
        System.out.println(lista.removeIndex(2));
        System.out.println(lista);
        System.out.println(lista.removeIndex(1));
        System.out.println(lista);
    }
}