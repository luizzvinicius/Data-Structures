package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        var exemplo = new int[] { 4, 7, 2, 6, 4, 1, 8, 3 };

        quickSort(exemplo);
        System.out.println(Arrays.toString(exemplo));
    }

    public static void quickSort(int[] array, int inicio, int fim) {
        if (inicio >= fim) {
            return;
        }

        int pivo = array[fim], menorPivo = inicio, maiorPivo = fim;

        while (menorPivo < maiorPivo) {
            while (array[menorPivo] <= pivo && menorPivo < maiorPivo) {
                menorPivo++;
            }
            while (array[maiorPivo] >= pivo && menorPivo < maiorPivo) {
                maiorPivo--;
            }
            troca(array, menorPivo, maiorPivo);
        }

        troca(array, menorPivo, fim);
        quickSort(array, inicio, menorPivo - 1);
        quickSort(array, maiorPivo + 1, fim);
    }

    private static void troca(int[] array, int index1, int index2) {
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}