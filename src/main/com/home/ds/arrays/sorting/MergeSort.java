package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 5, 9,4};

        System.out.println("Original Array: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array by mergeSort: " + Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {

        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(arr, startIndex, midIndex);
            mergeSort(arr, midIndex + 1, endIndex);
            merge(arr, startIndex, midIndex, midIndex+ 1,  endIndex);
        }
    }

    private static void merge(int[] arr, int leftStartIndex, int leftEndIndex, int rightStartIndex,  int rightEndIndex)
    {

        int[] arrLeftCopy = new int[leftEndIndex - leftStartIndex + 1];
        int leftC = 0;
        for(int temp = leftStartIndex; temp <= leftEndIndex; temp++)
        {
            arrLeftCopy[leftC++] = arr[temp];
        }

        int[] arrRightCopy = new int[rightEndIndex - rightStartIndex + 1];
        int rightC = 0;
        for(int temp = rightStartIndex; temp <= rightEndIndex; temp++)
        {
            arrRightCopy[rightC++] = arr[temp];
        }

        int i =0, j = 0;

        for (int k = leftStartIndex; k <= rightEndIndex; k++)
        {
            if( i >= leftC)
            {
                arr[k] = arrRightCopy[j];
                j++;
            }
            else if (j >= rightC)
            {
                arr[k] = arrLeftCopy[i];
                i++;
            }
            else if(arrLeftCopy[i] < arrRightCopy[j]) {
                arr[k] = arrLeftCopy[i];
                i++;
            }
            else
            {
                arr[k] = arrRightCopy[j];
                j++;
            }
        }
    }


}


