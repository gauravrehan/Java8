package com.home.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildCardUpperBound {
	
	
	public static double sumTheListWild(List<? extends Number> list)
	{
		double sum = 0.0d;
		for(Number num : list)
			sum += num.doubleValue();
		return sum;
	}

	
	public static <T extends Number> double sumTheListGeneric(List<T> list)
	{
		double sum = 0.0d;
		for(Number num : list)
			sum += num.doubleValue();
		return sum;
	}
	
	
	public static void main(String[] args) {
		List<Integer> lInt = Arrays.asList(1,2,4);

		System.out.println(sumTheListWild(lInt));
		System.out.println(sumTheListGeneric(lInt));
		
		List<Number> lNum = new ArrayList<Number>();
		lNum.add(1.1d);
		lNum.add(3.2d);
		lNum.add(1f);
		
		System.out.println(sumTheListWild(lNum));
		System.out.println(sumTheListGeneric(lNum));
		
		
		
	}

}
