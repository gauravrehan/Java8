package com.home.ds.arrays.rearrange;

import java.util.Arrays;

public class EvenOdd {
    public static void main(String[] args) {
        int [] arr = new int[]{6,9,5,8,4,5,2,1};

        System.out.println(Arrays.toString(arr));
        evenOdd(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void evenOdd(int[] arr)
    {
        int n = arr.length;

        int j = -1, i = 0;
        while (i != n) {
            System.out.println("i = " + i  + " j=" + j);
            if (arr[i] % 2 == 0)
            {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("swapped");
            }
            i++;
        }
    }
}
