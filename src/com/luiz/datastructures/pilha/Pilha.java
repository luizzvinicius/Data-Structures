package com.luiz.datastructures.pilha;

import com.luiz.datastructures.base.EstruturaEstatica;

public class Pilha<T> extends EstruturaEstatica<T> {
    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilha(T elem) {
        super.adiciona(elem);
    }

    public T topo() {
        if (this.isVazia()) {
            return null;
        }
        return this.vetor[this.adicionados-1];
    }

    public T desempilha() {
        if (this.isVazia()) return null;
        
        T last = this.vetor[this.adicionados - 1];
        this.vetor[this.adicionados - 1] = null;
        this.adicionados--;
        return last;
        // return this.vetor[--this.adicionados];
    }

}
