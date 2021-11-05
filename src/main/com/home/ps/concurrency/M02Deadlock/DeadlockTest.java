package com.home.ps.concurrency.M02Deadlock;

public class DeadlockTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		A a = new A();
		Runnable r1 = () -> a.a();
		Runnable r2 = () -> a.b();
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		t1.join();
		t2.join();
		
	}

}

class A {
	private Object key1 = new Object();
	private Object key2 = new Object();
			
	public void a() 
	{
		synchronized(key1)
		{
			System.out.println("[" + Thread.currentThread().getName() + "] I am in a()" );
			b();
		}
	}
	
	public void b()
	{
		synchronized(key2)
		{
			System.out.println("[" + Thread.currentThread().getName() + "] I am in b()" );
			a();
		}
	}
	
	
}
