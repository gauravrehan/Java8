package com.home.corejava.chapter06;

public class DataStructure {
	
	static int NUM = 3;
	private int SIZE = 15;	
	private int[] arrayOfInts = new int[SIZE];
	
	public DataStructure()
	{
		for(int i=0; i<SIZE; i++)
			arrayOfInts[i] = i;
	}
	
	public void printEven()
	{
		java.util.Iterator<Integer> evenIterator = new EvenIterator();
		while(evenIterator.hasNext())
		{
			System.out.println(evenIterator.next());
		}
			
	}
	
	private class EvenIterator implements java.util.Iterator<Integer> {

		//static member can only be declared in an inner class only if the inner class is marked as static.
		//static int SIZE = 3;
		private int nextIndex = 0;
		@Override
		public boolean hasNext() {
			if(nextIndex <= SIZE - 1)
				return true;
			return false;
		}

		@Override
		public Integer next() {
			nextIndex+=2;
			return nextIndex;
		}
	}	

	public static void main(String[] args) {
		DataStructure data = new DataStructure();
		data.printEven();
	}

}
