package com.luiz.datastructures.base;

public class EstruturaEstatica<T> {
    // Vai servir de base para as outras estruturas
    protected T[] vetor;
    protected int adicionados;

    @SuppressWarnings("unchecked")
    public EstruturaEstatica(int capacidade) {
        this.vetor = (T[]) new Object[capacidade];
        this.adicionados = 0;
    }

    protected void adiciona(T elem) {
        this.aumentaCapacidade();
        this.vetor[this.adicionados] = elem;
        this.adicionados++;
    }

    protected void adiciona(T elem, int index) throws Exception {
        this.aumentaCapacidade();
        if (index < 0 || index > this.adicionados) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        for (int i = this.adicionados; i > index; i--) {
            this.vetor[i] = this.vetor[i - 1];
        }
        this.vetor[index] = elem;
        this.adicionados++;
    }

    @SuppressWarnings("unchecked")
    private void aumentaCapacidade() {
        int size = this.vetor.length;
        if (this.adicionados == size) {
            T[] biggerVetor = (T[]) new Object[size * 2];
            for (int i = 0; i < this.vetor.length; i++) {
                biggerVetor[i] = this.vetor[i];
            }
            this.vetor = biggerVetor;
        }
    }

    protected void remove(int index) throws IllegalArgumentException {
        if (!(index >= 0 && index < this.adicionados)) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        for (int i = index; i < this.adicionados - 1; i++) {
            this.vetor[i] = this.vetor[i + 1];
        }
        this.adicionados--;
    }

    public int tamanho() {
        return this.adicionados;
    }

    public boolean isVazia() {
        return this.adicionados == 0;
    }

    @Override
    public String toString() {
        var s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.adicionados; i++) {
            s.append(this.vetor[i]);
            s.append(", ");
        }

        if (this.adicionados > 0) {
            int size = s.length();
            s.delete(size - 2, size);
        }

        s.append("]");
        return s.toString();
    }
}