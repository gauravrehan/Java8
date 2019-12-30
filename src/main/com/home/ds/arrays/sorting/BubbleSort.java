package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 5, 9};

        System.out.println("Original Array: " + Arrays.toString(arr));

        bubbleSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr, int startIndex, int endIndex) {
        for (int j = endIndex; j >= startIndex; j--) {

            for (int i = startIndex; i <= j - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        return;
    }
}
