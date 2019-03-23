package com.home.corejava.threads;

public class BasicThread implements Runnable {

	public void run() {

		try {
			executeTask();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void executeTask() throws InterruptedException {
		//printThreadProperties();

		try {

			/*
			 * There is no need to check for isInterrupted if in your loop you
			 * are calling sleep method after every iteration. if inturrpted,
			 * while sleep the thread will not sleep instead it will reset the
			 * flag and throw the InterruptedExcpetion
			 */
			while (!Thread.interrupted() && true) {
				System.out.println(Thread.currentThread().getState());
				Thread.sleep(500);
			}

			System.out.println("Thread inturrpted, existed while block");
		} 
		finally {
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new BasicThread();
		Thread tRunnable = new Thread(runnable);
		tRunnable.start();
		Thread.sleep(1000);
		tRunnable.interrupt();
		tRunnable.join();
	}

	private static void printThreadProperties() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getState());
		System.out.println(Thread.currentThread().getPriority());
	}

}
