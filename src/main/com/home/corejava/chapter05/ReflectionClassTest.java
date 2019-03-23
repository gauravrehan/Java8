package com.home.corejava.chapter05;

import java.util.Random;

public class ReflectionClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println(ReflectionClassTest.class.getName());
		
		String classNametoInstantiate = "java.util.Random";
		Class cRandomClass = Class.forName(classNametoInstantiate);
		java.util.Random obj = (Random) cRandomClass.newInstance();
		System.out.println(obj.getClass().getName());
		System.out.println(obj.nextInt());
		
		
		
		int a[] = new int[5];
		System.out.println(a.getClass().getName());

		Integer A[] = new Integer[5];
		System.out.println(A.getClass().getName());
		
		
	}
	
	
	/**
	 * A generic method that create a new Array of any object types. Similar to Arrays.copyOf()
	 * @param a
	 * @param newLength
	 * @return
	 */
	public static Object goodCopyOf(Object a, int newLength)
	{
	   Class cl = a.getClass();
	   if (!cl.isArray()) return null;
	   Class componentType = cl.getComponentType();
	   int length = java.lang.reflect.Array.getLength(a);
	   Object newArray = java.lang.reflect.Array.newInstance(componentType, newLength);
	   System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
	   return newArray;
	}

}
