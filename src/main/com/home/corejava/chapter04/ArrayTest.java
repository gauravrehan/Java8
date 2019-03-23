package com.home.corejava.chapter04;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args)
	{
		int[] a = new int[100];
		for(int i=0; i< 100; i++)
		{
			a[i] = (int) (Math.random() * 100) ;
		}
		
		Arrays.sort(a);
//		for(int aint : a)
//		{
//			System.out.println(aint);
//		}
//		
		System.out.println(Arrays.toString(a));
	}

}
