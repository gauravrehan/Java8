package com.home.generics;

public class Util {
	
	public static <T extends Comparable<T>> int greaterThanCountCalculator (T[] tArray, T item)
	{
		int count = 0;
		
		for(T t : tArray)
		{
			if(t.compareTo(item) > 0)
				count++;
		}
		
		return count;
	}
	
	
 
}
