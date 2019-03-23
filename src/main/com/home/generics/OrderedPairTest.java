package com.home.generics;

import java.util.List;
import java.util.ArrayList;

public class OrderedPairTest {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// 
		
		Pair<String, Integer> pair1 = new OrderedPair<String, Integer>("gaurav", 35);
		
		Pair<String, Integer> pair2 = new OrderedPair<>("richa", 30);
		
		Box<Integer> b = new Box<>();
		b.set(Integer.valueOf(6));
		Pair<String, Box<Integer>> pair3 = new OrderedPair<>("aarav", b);
		
		
		System.out.println(pair1.getKey());
		System.out.println(pair2.getKey());
		System.out.println(pair3.getKey());
		
		
//		With RAW type reference, we can insert any object and get that object with raw or generic reference.
		
		@SuppressWarnings("rawtypes")
		Box b1 = b;
		
		
		b1.set("TEST");
		System.out.println(b1.get());
//		this line below fails as the object is of type string and not int.
//		System.out.println(b.get().intValue());
		
		
		Box braw = new Box();
		braw.set("yahoo");
		Box<Integer> bgen = braw;
		//bgen.set(Integer.valueOf(45));
		System.out.println(braw.get());
		//this will return in error because the inserted type is of string and not integer
		//System.out.println(bgen.get().intValue());
		
		
		
		List<String> sList = new ArrayList<>();
		sList.add("yahoo String");
		List sListraw = sList;
		sListraw.add(Integer.valueOf(67));
		System.out.println(sListraw.toString());
		
		List sListraw1 = new ArrayList();
		sListraw1.add("yahoo String");
		List<Integer> sList1 = sListraw1;
		sListraw1.add(Integer.valueOf(67));
		System.out.println(sListraw1.toString());
		System.out.println(sList1.get(0).intValue());
		
		
		
	}

}
