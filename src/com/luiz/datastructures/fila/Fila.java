package com.luiz.datastructures.fila;

import com.luiz.datastructures.base.EstruturaEstatica;

public class Fila<T> extends EstruturaEstatica<T> {
    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elem) {
        super.adiciona(elem);
    }

    public T espiar() {
        if (this.isVazia()) {
            return null;
        }
        return this.vetor[0];
    }
    
    public T desenfileira() {
        if (this.isVazia()) return null;
        
        T first = this.vetor[0];
        super.remove(0);
        return first;
    }
}