package com.luiz.datastructures.lista;

public class ListaTeste {
    public static void main(String[] args) {
        var lista = new ListaEncadeada<Integer>();

        lista.adiciona(6);
        lista.adiciona(9);
        lista.adiciona(10);
        lista.adiciona(1, 7);

        System.out.println(lista);
    }
}