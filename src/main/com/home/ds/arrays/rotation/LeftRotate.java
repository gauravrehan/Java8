package com.home.ds.arrays.rotation;

import java.util.Arrays;

/*
Juggle Algorithm to rotate the array k positions to left with space complexity as O(1)
Time complexity is O(n)
n = array length
k = positions to rotate to left
gcd = greatest common divisor. for example gcd of 7 and 1 is 1. and 7 and 7 is 7. 7 and 2 is 1.
outer loops goes from 0 to < gcd
inner loop starts at i and terminate at i.
 */
public class LeftRotate {

    static int[] a = new int[]{1,2,3,4,5};

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(a));
        new LeftRotate().juggleAlgorithm(a, 5, 4, 1);
        System.out.println(Arrays.toString(a));
    }

    private void juggleAlgorithm(int[] array, int n , int k, int gcd)
    {
        for(int i = 0; i < gcd; i++)
        {

            int temp = a[i];
            int j = i;

            while(true) {
                int d = (j + k) % n;
                if (d != i)
                {
                    a[j] = a[d];
                    j = d;
                }
                else
                {
                    a[j] = temp;
                    break;
                }
            }
        }
    }
}
