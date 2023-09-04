package com.luiz.datastructures.lista.teste;

import com.luiz.datastructures.lista.ListaEncadeada;

public class ListaTeste {
    public static void main(String[] args) {
        var lista = new ListaEncadeada<Integer>();

        lista.adiciona(5);
        lista.adiciona(6);
        lista.adiciona(9);
        lista.adiciona(13);
        lista.adiciona(17);
        
        try {
            lista.remove(20);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(lista);
    }
}