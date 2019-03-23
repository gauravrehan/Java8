package com.home.corejava.threads;

public class UnsynchBankTest {

	/*
	 * To cause deadlock change num accounts to 10 and increase the init balance limit to 2 * Inittial balance
	 * then connect jconsole to see the threads that all were in waiting state.
	 * hence the deadlock
	 * 
	 */
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}