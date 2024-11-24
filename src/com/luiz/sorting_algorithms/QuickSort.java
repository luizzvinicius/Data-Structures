package com.luiz.sorting_algorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        var exemplo = new int[]{4, 7, 0, 2, 6, 4, 9, 1, 8, 3};

        quickSort(exemplo);
        System.out.println(Arrays.toString(exemplo));
    }

    public static void quickSort(int[] array, int start, int end) {
        if (end <= start) return;

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        i++;
        swap(array, i, end);
        return i;
    }

    private static void swap(int[] array, int index1, int index2) {
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
}