package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        var exemplo = new int[] { 4, 7, 2, 5, 4, 0 };
        var representacao = Arrays.toString(insertion(exemplo));

        System.out.println(representacao);
    }

    public static int[] insertion(int[] desordenada) {
        int aux, j = 0;
        for (int i = 1; i < desordenada.length; i++) {
            aux = desordenada[i];
            j = i - 1;
            while (j >= 0 && desordenada[j] > aux) {
                desordenada[j + 1] = desordenada[j];
                j--;
            }
            desordenada[j + 1] = aux;
        }
        return desordenada;
    }
}