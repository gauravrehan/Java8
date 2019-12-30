package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 5, 9};

        System.out.println("Original Array: " + Arrays.toString(arr));

        selectionSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array by selectionSort: " + Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr, int startIndex, int endIndex) {
        for (int j = startIndex; j <= endIndex; j++) {

            int min = j;

            for (int i = j; i <= endIndex; i++) {
                if(arr[i] < arr[min])
                {
                    min = i;
                }

            }

            if(min != j)
                {
                    int temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;
                }
        }

        return;
    }


}


