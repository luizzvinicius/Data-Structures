package com.luiz.datastructures.tree;

public class Arvore<T> {
    private No<T> raiz;
    private int tamanho;

    public Arvore() {
        this.raiz = null;
    }

    public Arvore(T valor) {
        this.raiz = new No<T>(valor);
        this.tamanho++;
    }

    public void adiciona(T valor) {
        No<T> novo = new No<>(valor);
        if (this.tamanho == 0) {
            this.raiz = novo;
            this.tamanho++;
        } else {
            No<T> atual = this.raiz;
            @SuppressWarnings("unchecked")
            Comparable<T> chave = (Comparable<T>) valor;
            while (true) {
                if (chave.compareTo(atual.getValor()) < 0) {
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novo);
                        this.tamanho++;
                        break;
                    }
                } else {
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novo);
                        this.tamanho++;
                        break;
                    }
                }
            }
        }
    }

    public void emOrdem(No<T> init) {
        if (init != null) {
            emOrdem(init.getEsquerda());
            System.out.print(init.getValor() + " ");
            emOrdem(init.getDireita());
        }
    }

    public void preOrdem(No<T> init) {
        if (init != null) {
            System.out.print(init.getValor() + " ");
            preOrdem(init.getEsquerda());
            preOrdem(init.getDireita());
        }
    }

    public void posOrdem(No<T> init) {
        if (init != null) {
            posOrdem(init.getEsquerda());
            posOrdem(init.getDireita());
            System.out.print(init.getValor() + " ");
        }
    }

    private void validaIndexBusca(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index < this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }
        var builder = new StringBuilder("[");

        return builder.toString();
    }
}