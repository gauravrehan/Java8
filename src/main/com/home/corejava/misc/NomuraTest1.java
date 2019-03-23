package com.home.corejava.misc;

public class NomuraTest1 {
	
	
	public static void main(String[] args)
	{
		int[] a = new int[] {1,1};
		System.out.println(maxDifference(a));
		
	}
	
	static int maxDifference(int[] a)
	{
		
		int N = a[0];
		if( N > 100000 || N < 1)
			return -1;
			
		int maxIndex = 1;
		int minIndex = 1;
		
		for (int i= 1; i <= N; i++)
		{
			if(a[i] >= a[maxIndex])
				maxIndex = i;
		}
		
		
		if(maxIndex == 1)
			return -1;
		
		
		for (int i= 1; i <= maxIndex; i++)
		{
			
			if(a[minIndex] > a[i])
			{
				minIndex = i;
			}
		}
		return a[maxIndex] - a[minIndex];
	}

}
