package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        var exemplo = new int[] { 4, 9, 2, 1, 7, 8 };
        var representacao = Arrays.toString(bubbleSort(exemplo));

        System.out.println(representacao);
    }

    public static int[] bubbleSort(int[] desordenada) {
        int copia;
        for (int j = 0; j < desordenada.length - 1; j++) { // percorrer a lista n-1 vezes garante que vai estar ordenada
            for (int i = 0; i < desordenada.length - 1; i++) {
                if (desordenada[i] > desordenada[i + 1]) {
                    copia = desordenada[i];
                    desordenada[i] = desordenada[i + 1];
                    desordenada[i + 1] = copia;
                }
            }
        }
        return desordenada;
    }
}