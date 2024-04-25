package com.luiz.datastructures.tree;

public class No<T> {
    private T valor;
    private No<T> direita;
    private No<T> esquerda;

    public No(T valor) {
        this.valor = valor;
    }

    public No() {
        this.valor = null;
    }

    public T getValor() {
        return valor;
    }

    public No<T> getDireita() {
        return direita;
    }

    public void setDireita(No<T> direita) {
        this.direita = direita;
    }

    public No<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append(this.valor);
        return builder.toString();
    }
}