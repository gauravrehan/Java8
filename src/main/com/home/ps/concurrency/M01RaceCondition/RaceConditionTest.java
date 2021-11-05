package com.home.ps.concurrency.M01RaceCondition;
/*
 * without the synchronized incrementAndSet, we will always get some random number instead of 2000
 */
public class RaceConditionTest {
	public static void main(String[] args) throws InterruptedException {
		IntWrapper iWrapper = new IntWrapper();
		
		Runnable r1 = () -> {
			for(int i =0; i < 1000; i++)
				iWrapper.incrementAndSet();
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Value of IntWrpper: " + iWrapper.getValue());
		
	}

}

class IntWrapper{
	
	private int i;
	
	public IntWrapper()
	{
		i = 0;
	}
	
	public int getValue()
	{
		return i;
	}
	
	public synchronized void incrementAndSet()
	{
		i = i + 1;
	}
	
}
