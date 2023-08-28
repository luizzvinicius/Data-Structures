package com.luiz.datastructures.lista.teste;

import com.luiz.datastructures.lista.ListaEncadeada;

public class ListaTeste {
    public static void main(String[] args) {
        var lista = new ListaEncadeada<Integer>();

        lista.adiciona(5);
        lista.adiciona(9);
        lista.adiciona(13);
        lista.adiciona(17);

        lista.limpa();
        System.out.println(lista);
    }
}