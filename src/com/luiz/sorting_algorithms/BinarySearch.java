package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        var num = new int[] { 0, 1, 4, 5, 6, 8, 9 };

        for (int i : num) {
            System.out.print(binarySearch(num, i) + " ");
            System.out.println(Arrays.binarySearch(num, i));
        }
    }

    public static int binarySearch(int[] array, int value) {
        if (value < array[0] || value > array[array.length - 1]) {
            return -1;
        }

        int inicio = 0, meio = 0, ultimo = array.length - 1;
        while (inicio <= ultimo) {
            meio = (inicio + ultimo) / 2;
            if (array[meio] == value) {
                return meio;
            } else if (value < array[meio]) {
                ultimo = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }

    // public static int binarySearchRecursive(int[] array, int value, int inicio, int fim) { // Recursivo
    //     if (inicio <= fim) {
    //         int middle = (inicio + fim) / 2;

    //         if (array[middle] > value) {
    //             return binarySearchRecursive(array, value, inicio, middle - 1);
    //         } else if (array[middle] < value) {
    //             return binarySearchRecursive(array, value, middle + 1, fim);
    //         }
    //         return middle;
    //     }
    //     return -1;
    // }
}