package com.luiz.datastructures.tree.testes;

import com.luiz.datastructures.tree.Arvore;

public class TestArvore {
    public static void main(String[] args) {
        var arvore = new Arvore<Integer>();
        arvore.adiciona(10);
        arvore.adiciona(8);
        arvore.adiciona(5);
        arvore.adiciona(7);
        arvore.adiciona(6);
        arvore.adiciona(9);
        arvore.adiciona(7);
        arvore.adiciona(18);
        arvore.adiciona(13);
        arvore.adiciona(15);
        arvore.adiciona(11);

        arvore.emOrdem(arvore.getRaiz());
        System.out.println("\n" + arvore.remove(7, arvore.getRaiz()));
        arvore.emOrdem(arvore.getRaiz());
        // System.out.println("\n" + arvore.getRaiz());
    }
}