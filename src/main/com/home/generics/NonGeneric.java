package com.home.generics;

import java.util.List;
import java.util.ArrayList;

public class NonGeneric {
	
	public static void main(String[] args)
	{
		List list = new ArrayList();
		list.add("hello");
		String s = (String) list.get(0);
		System.out.println(s);
		
		List<String> listGeneric = new ArrayList<String>();
		listGeneric.add("hello");
		s = listGeneric.get(0);   // no cast
		System.out.println(s);
		
		//what happens when i create a generic list of object type and try to insert string into it?
		
		List<Object> objs = new ArrayList<>();
		objs.add("Gaurav Rehan");
		objs.add(new Integer(5));
		
		for(Object o : objs)
		{
			System.out.println(o);
		}
		
	}

}
