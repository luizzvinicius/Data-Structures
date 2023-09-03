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

    public void adiciona(T elem, int index) {
        try {
            this.validaIndex(index);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return;
        }
        
        No<T> novoNo = new No<>(elem);
        No<T> inicial = this.inicio, anterior = this.inicio;
        if (index == 0) {
            No<T> novaCabeca = new No<>(elem, inicial); // apenas para usar o outro construtor
            this.inicio = novaCabeca;
        } else if (index == this.tamanho) {
            this.adiciona(elem);
            return; // para não aumentar o tamanho 2x
        } else {
            for (int i = 0; i < index; i++) {
                if (i + 1 == index) {
                    novoNo.setProximo(anterior.getProximo());
                    anterior.setProximo(novoNo);
                }
                inicial = inicial.getProximo();
                anterior = anterior.getProximo();
            }
        }
        this.tamanho++;
    }

    public int index(T elem) {
        var start = this.inicio;
        for (var i = 0; i < this.tamanho; i++) {
            if (start.getElem().equals(elem)) {
                return i;
            }
            start = start.getProximo();
        }
        return -1;
    }

    public T busca(int index) throws Exception {
        if (!(index >= 0 && index < this.tamanho)) {
            throw new Exception("indice inválido");
        }

        var start = this.inicio;
        for (int i = 0; i < index; i++) {
            start = start.getProximo();
        }
        return start.getElem();
    }

    public No<T> remove(int index) {
        No<T> elem = this.inicio;
        return elem;
    }

    public void remove(T elem) {

    }

    public No<T> getFirst() throws Exception {
        var elem = this.inicio;
        if (elem == null) {
            throw new Exception("Elemento é null");
        }
        return elem;
    }

    public No<T> getLast() throws Exception {
        var elem = this.ultimo;
        if (elem == null) {
            throw new Exception("Elemento é null");
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

    private void validaIndex(int index) throws Exception {
        if (!(index >= 0 && index <= this.tamanho)) {
            throw new Exception("indice inválido");
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
        var atual = this.inicio;

        for (var i = 0; i < this.tamanho; i++) {
            builder.append(atual.getElem()).append(", ");
            atual = atual.getProximo();
        }
        builder.delete(builder.length() - 2, builder.length()).append("]");
        return builder.toString();
    }
}