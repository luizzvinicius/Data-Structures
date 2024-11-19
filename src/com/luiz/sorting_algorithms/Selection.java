package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        var exemplo = new int[]{20, 9, 2, 1, 7, 8, 0, 3, 15, 11};
        var representacao = Arrays.toString(selection(exemplo));

        System.out.println(representacao);
    }

    public static int[] selection(int[] desordenada) {
        int indiceMenor = 0, copia;
        for (int i = 0; i < desordenada.length - 1; i++) {
            indiceMenor = i;
            for (int ii = i + 1; ii < desordenada.length; ii++) { // ao final do for anterior, diminui o tamanho que percorre
                if (desordenada[ii] < desordenada[indiceMenor]) {
                    indiceMenor = ii;
                }
            }
            copia = desordenada[indiceMenor];
            desordenada[indiceMenor] = desordenada[i];
            desordenada[i] = copia;
        }
        return desordenada;
    }
}