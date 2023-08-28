package com.luiz.datastructures.lista;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public void adiciona(T elem) {
        var no = new No<T>(elem);
        if (this.tamanho == 0) {
            this.inicio = no;
        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.tamanho++;
    }

    public void limpa() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElem(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.tamanho = 0;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        var builder = new StringBuilder("[");
        var atual = this.inicio;

        for (var i = 0; i < this.tamanho; i++) {
            builder.append(atual.getElem()).append(", ");
            atual = atual.getProximo();
        }
        builder.delete(builder.length() - 2, builder.length()).append("]");
        return builder.toString();
    }
}