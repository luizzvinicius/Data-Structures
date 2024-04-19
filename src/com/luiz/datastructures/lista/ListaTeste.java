package com.luiz.datastructures.lista;

import java.util.Arrays;

public class ListaTeste {
    public static void main(String[] args) {
        var lista = new ListaEncadeada<Integer>();

        lista.adiciona(1);
        lista.adiciona(3);
        lista.adiciona(7);
        lista.adiciona(9);

        lista.inserirOrdenado(4);

        lista.inverteLista();
        lista.toVector();
        System.out.println(Arrays.toString(lista.toVector()));
        System.out.println(lista);
    }
}