package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 5, 9};

        System.out.println("Original Array: " + Arrays.toString(arr));

        insertionSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array by insertionSort: " + Arrays.toString(arr));

    }

    public static void insertionSort(int[] arr, int startIndex, int endIndex) {

        for(int i = startIndex; i <= endIndex; i++)
        {
            int subArrEndIndex = i;
           // if(subArrEndIndex != startIndex)
            //{
                int findPlaceFor = subArrEndIndex;
                while(findPlaceFor - 1 >= startIndex && arr[findPlaceFor] < arr[findPlaceFor - 1] )
                {
                    int temp = arr[findPlaceFor];
                    arr[findPlaceFor] = arr[findPlaceFor - 1];
                    arr[findPlaceFor - 1] = temp;
                    findPlaceFor--;
                }

            //}
        }
        return;
    }


}


