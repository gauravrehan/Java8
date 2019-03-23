package com.home.corejava.threads;

import java.util.concurrent.locks.*;

/*
 * Instead of using explicit lock and condition object, we can use basic synchronized keyword
 * with wait, notifyAll
 * limitation is that synchronized uses intrinsic lock which can only have a single condition.
 * and you cannot interrupt a thread that is trying to acquire a lock
 * no timeout can be speified while trying to acquire a lock.
 * 
 * ideally we should not use lock/conditions and neither the synchronized. instead we should
 * use other highlevel construct java provides.
 * 
 */
public class Bank {

	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
		
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}

	public void /* synchronized */ transfer(int from, int to, double amount) {
		
		try
		{
			
		bankLock.lock();
		
		while (accounts[from] < amount)
			try {
				sufficientFunds.await();
				//if using synchronized transfer
				//wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		
		
		sufficientFunds.signalAll();
		  
		 
		//if using synchronized transfer
		//notifyAll();
		}
		finally
		{
			bankLock.unlock();
		}
	}

	public double getTotalBalance()
	     {
		
	        double sum = 0;
	
	        for (double a : accounts)
	           sum += a;
	
	        return sum;
	     }

	public int size() {
		return accounts.length;
	}

}
