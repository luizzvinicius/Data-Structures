package com.luiz.datastructures.tree;

import com.luiz.datastructures.fila.Fila;

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
        while (atual != null) {
            if (chave.compareTo(atual.getValor()) < 0) {
                atual = atual.getEsquerda();
            } else if (chave.compareTo(atual.getValor()) > 0) {
                atual = atual.getDireita();
            } else {
                return true;
            }
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

    public void emNivel() {
        if (this.raiz == null) {
            return;
        }

        var fila = new Fila<No<T>>(this.tamanho);
        fila.enfileira(this.raiz);

        System.out.print("[");
        while (fila.tamanho() != 0) {
            No<T> removido = fila.desenfileira();
            if (removido.getEsquerda() != null) {
                fila.enfileira(removido.getEsquerda());
            }
            if (removido.getDireita() != null) {
                fila.enfileira(removido.getDireita());
            }
            System.out.print(" " + removido);
        }
        System.out.print("]");
    }

    public int height(No<T> init) { // usa a lógica do posOrdem | Entender melhor
        if (init == null) {
            return 0;
        }
        if (init.getEsquerda() == null && init.getDireita() == null) {
            return 1;
        }

        int altEsq = 0, altDir = 0;

        if (init.getEsquerda() != null) {
            altEsq = this.height(init.getEsquerda());
        }

        if (init.getDireita() != null) {
            altDir = this.height(init.getDireita());
        }

        return 1 + Math.max(altEsq, altDir);
    }

    public T menor() {
        No<T> atual = this.raiz;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual.getValor();
    }

    public T maior() {
        No<T> atual = this.raiz;
        while (atual.getDireita() != null) {
            atual = atual.getDireita();
        }
        return atual.getValor();
    }

    public int getTamanho() {
        return tamanho;
    }

    public No<T> getRaiz() {
        return raiz;
    }
}