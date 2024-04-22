package com.luiz.datastructures.tree;

public class Arvore<T> {
    private No<T> raiz;
    private No<T> ultimo;
    private int tamanho;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(T valor) {
        this.raiz = new No<T>(valor);
        this.tamanho++;
    }

    public void adiciona(T valor) {
        if (this.tamanho == 0) {
            this.raiz = new No<>(valor);
        }
        this.tamanho++;
    }

    public void adiciona(int index, T valor) throws IllegalArgumentException {
        this.validaIndexInsert(index);

        if (this.tamanho == 0) {
            this.adiciona(valor);
            return;
        } else if (index == this.tamanho) {
            
        }
    }

    // private No<T> buscaNo(int index) throws IllegalArgumentException {
    //     @SuppressWarnings("unchecked") Comparable<T> chave = (Comparable<T>) valor;
        
    //     No<T> atual= this.raiz;
    //     for (int i = 0; i < index; i++) {
    //         if (chave.compareTo(atual.getValor()) < 0) {
    //             atual = atual.getEsquerda();
    //         } else if (chave.compareTo(atual.getValor()) > 0) {
    //             atual = atual.getDireita();
    //         } else {
    //             return atual;
    //         }
    //     }
    //     return null;
    // }

    private void validaIndexBusca(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index < this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
    }

    private void validaIndexInsert(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index <= this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getUltimo() {
        return ultimo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[raiz=").append(raiz).append("]");
        return builder.toString();
    }
}