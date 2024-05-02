package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        var exemplo = new int[] { 4, 9, 2, 1, 7, 8, 0, 3, 15, 11, 3 };
        mergeSort(exemplo);

        System.out.println(Arrays.toString(exemplo));
    }

    public static void mergeSort(int[] desordenada) {
        int tamanho = desordenada.length;
        if (tamanho < 2) {
            return;
        }

        int metade = tamanho / 2;
        var esquerda = new int[metade];
        for (int i = 0; i < metade; i++) {
            esquerda[i] = desordenada[i];
        }

        var direita = new int[tamanho - metade];
        for (int i = metade; i < tamanho; i++) {
            direita[i - metade] = desordenada[i];
        }

        mergeSort(esquerda);
        mergeSort(direita);
        merge(desordenada, esquerda, direita);
    }

    private static void merge(int[] desordenada, int[] esquerda, int[] direita) {
        int indexEsquerda = 0, indexDireita = 0, indexDesord = 0;
        while (indexEsquerda < esquerda.length && indexDireita < direita.length) {
            if (esquerda[indexEsquerda] <= direita[indexDireita]) {
                desordenada[indexDesord] = esquerda[indexEsquerda];
                indexEsquerda++;
            } else {
                desordenada[indexDesord] = direita[indexDireita];
                indexDireita++;
            }
            indexDesord++;
        }

        while (indexEsquerda < esquerda.length) {
            desordenada[indexDesord] = esquerda[indexEsquerda];
            indexEsquerda++;
            indexDesord++;
        }

        while (indexDireita < direita.length) {
            desordenada[indexDesord] = direita[indexDireita];
            indexDireita++;
            indexDesord++;
        }
    }
}