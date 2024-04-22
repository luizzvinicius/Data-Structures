package com.luiz.datastructures.tree.testes;

import com.luiz.datastructures.tree.Arvore;

public class TestArvore {
    public static void main(String[] args) {
        var arvore = new Arvore<Integer>();
        arvore.adiciona(10);


        System.out.println(arvore);
    }   
}