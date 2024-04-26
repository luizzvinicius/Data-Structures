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

    public boolean contains(T valor) {
        No<T> atual = this.raiz;
        @SuppressWarnings("unchecked")
        Comparable<T> chave = (Comparable<T>) valor;
        int index = 0;
        while (index < this.tamanho) {
            if (chave.compareTo(atual.getValor()) < 0) {
                if (atual.getEsquerda() != null) {
                    atual = atual.getEsquerda();
                } else {
                    return false;
                }
            } else if (chave.compareTo(atual.getValor()) > 0) {
                if (atual.getDireita() != null) {
                    atual = atual.getDireita();
                } else {
                    return false;
                }
            } else {
                return true;
            }
            index++;
        }
        return false;
    }

    public void emOrdem(No<T> init) {
        // if (init != null) {
        //     emOrdem(init.getEsquerda());
        //     System.out.print(init.getValor() + " ");
        //     emOrdem(init.getDireita());
        // }
        if (init.getEsquerda() != null) {
            emOrdem(init.getEsquerda());
        }
        System.out.print(init.getValor() + ", ");
        if (init.getDireita() != null) {
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

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getRaiz() {
        return raiz;
    }
}