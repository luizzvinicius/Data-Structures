package com.luiz.datastructures.lista;

import java.util.NoSuchElementException;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho;

    public void adiciona(T elem) {
        No<T> no = new No<>(elem);
        if (this.tamanho == 0) {
            this.inicio = no;
        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.tamanho++;
    }

    public void adicionaInicio(T elem) {
        if (this.tamanho == 0) {
            this.adiciona(elem);
        } else {
            No<T> novoElem = new No<>(elem, this.inicio); // apenas para usar o outro construtor
            this.inicio = novoElem;
            this.tamanho++;
        }
    }

    public void adiciona(int index, T elem) throws IllegalArgumentException {
        if (index < 0 || index > this.tamanho) {
            throw new IllegalArgumentException("Índice inválido");
        }

        if (index == 0) {
            this.adicionaInicio(elem);
        } else if (index == this.tamanho) {
            this.adiciona(elem);
        } else {
            No<T> novoNo = new No<>(elem);
            No<T> inicial = this.inicio;
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    novoNo.setProximo(inicial.getProximo());
                    inicial.setProximo(novoNo);
                }
                inicial = inicial.getProximo();
            }
            this.tamanho++;
        }
    }

    public int index(T elem) {
        No<T> start = this.inicio;
        for (int i = 0; i < this.tamanho; i++) {
            if (start.getElem().equals(elem)) {
                return i;
            }
            start = start.getProximo();
        }
        return -1;
    }

    private No<T> buscaNo(int index) throws IllegalArgumentException {
        this.validaIndex(index);

        No<T> start = this.inicio;
        for (int i = 0; i < index; i++) {
            start = start.getProximo();
        }
        return start;
    }

    public T busca(int index) throws IllegalArgumentException {
        return this.buscaNo(index).getElem();
    }

    public T removeIndex(int index) throws IllegalArgumentException {
        this.validaIndex(index);

        No<T> inicial = this.inicio;
        T retorno = null;
        if (index == 0) {
            retorno = this.removeFirst();
        } else if (index == this.tamanho - 1) {
            retorno = this.removeLast();
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    retorno = inicial.getProximo().getElem();
                    inicial.getProximo().setElem(null);
                    var aux = inicial.getProximo().getProximo();
                    inicial.getProximo().setProximo(null);
                    inicial.setProximo(aux);
                }
                inicial = inicial.getProximo();
            }
            this.tamanho--;
        }
        return retorno;
    }

    public T removeFirst() {
        if (this.tamanho == 0) {
            return null;
        }

        No<T> curr = this.inicio;
        T currValue = curr.getElem();
        this.inicio = this.inicio.getProximo();
        curr.setElem(null);
        curr.setProximo(null);
        this.tamanho--;
        return currValue;
    }

    public T removeLast() {
        if (this.tamanho == 0) {
            return null;
        }

        No<T> inicial = this.inicio;
        T lastValue = this.ultimo.getElem();
        for (int i = 0; i < this.tamanho - 1; i++) {
            if (i == this.tamanho - 1) {
                this.ultimo = inicial;
                inicial.getProximo().setElem(null);
                inicial.setProximo(null);
            }
            inicial = inicial.getProximo();
        }
        this.tamanho--;
        return lastValue;
    }

    public void remove(T elem) {
        int index = this.index(elem);
        if (index == -1) {
            return;
        }

        this.removeIndex(index);
    }

    public No<T> getFirst() throws NoSuchElementException {
        No<T> elem = this.inicio;
        if (elem == null) {
            throw new NoSuchElementException("Elemento é null");
        }
        return elem;
    }

    public No<T> getLast() throws NoSuchElementException {
        No<T> elem = this.ultimo;
        if (elem == null) {
            throw new NoSuchElementException("Elemento é null");
        }
        return elem;
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

    private void validaIndex(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index < this.tamanho)) {
            throw new IllegalArgumentException("Índice inválido");
        }
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

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElem()).append(", ");
            atual = atual.getProximo();
        }

        builder.append(atual.getElem()).append("]");
        return builder.toString();
    }
}