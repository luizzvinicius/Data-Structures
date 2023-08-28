package com.luiz.datastructures.lista;

public class No<T> {
    private T elem;
    private No<T> proximo;

    public No(T elem) {
        this.elem = elem;
        this.proximo = null; // redundante
    }

    public No(T elem, No<T> proximo) {
        this.elem = elem;
        this.proximo = proximo;
    }

    public T getElem() {
        return elem;
    }

    public void setElem(T elem) {
        this.elem = elem;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "No [elem=" + elem + ", proximo=" + proximo + "]";
    }
}