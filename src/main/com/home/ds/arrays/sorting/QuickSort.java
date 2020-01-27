package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 5, 9};

        System.out.println("Original Array: " + Arrays.toString(arr));



        selectionSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array by QuickSort: " + Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex < endIndex)
        {
            int pivot = partition(arr, startIndex, endIndex);
            selectionSort(arr, startIndex, pivot - 1);
            selectionSort(arr, pivot + 1, endIndex);
        }
    }

    private static int partition(int[] arr, int startIndex, int endIndex)
    {
        int pivotIndex = endIndex;
        int i = startIndex;
        for(int j = i; j<= pivotIndex -1; j++)
        {
            if (arr[j] <= arr[pivotIndex])
            {
                //swap ai with aj
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        //now swap ai with pivotindex
        int temp = arr[i];
        arr[i] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        return i;

    }




}


