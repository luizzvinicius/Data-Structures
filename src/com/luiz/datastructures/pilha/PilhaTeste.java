package com.luiz.datastructures.pilha;

public class PilhaTeste {
    public static void main(String[] args) {
        var pilha = new Pilha<Integer>(12);
        pilha.empilha(12);
        System.out.println(pilha);
    }
    
}