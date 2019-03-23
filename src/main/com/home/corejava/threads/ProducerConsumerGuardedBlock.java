package com.home.corejava.threads;

public class ProducerConsumerGuardedBlock {
	
	static class Drop{
		boolean empty = true;
		String message;
		
		public synchronized void put(String message)
		{
			if (!empty)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			empty = false;
			this.message = message;
			
			notifyAll();
		}
		
		public synchronized String take()
		{
			if(empty)
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			empty = true;
			notifyAll();
			return message;
		}
	}
	
	static class Producer implements Runnable
	{
		private Drop drop;
		
		public Producer(Drop drop)
		{
			this.drop = drop;
		}
		

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				drop.put("Message " + i);
			}
			drop.put("DONE");
		}
	}
	
	static class Consumer implements Runnable
	{

		private Drop drop;
		
		public Consumer(Drop drop)
		{
			this.drop = drop;
		}
		

		@Override
		public void run() {
			for(String s = drop.take(); !s.equals("DONE"); s = drop.take())
			{
				System.out.println(s);
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		
		Drop d = new Drop();
		Thread t1 = new Thread(new Producer(d));
		Thread t2 = new Thread(new Consumer(d));
		t1.start();
		t2.start();
	}

}
