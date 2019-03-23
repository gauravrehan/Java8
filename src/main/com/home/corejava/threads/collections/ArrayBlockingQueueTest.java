package com.home.corejava.threads.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.io.File;

public class ArrayBlockingQueueTest {

	private static ArrayBlockingQueue<String> bQ;
	private static final int BQ_MAX_DEAPTH = 1;
	private static final String ROOT = "C:\\Users\\richa\\Documents\\tools\\eclipse-ws\\corejava";
	private static final int C_THREADS = 10;
	
	public static void main(String[] args) {
		bQ = new ArrayBlockingQueue<String>(BQ_MAX_DEAPTH);
		Thread pThread = new Thread(new Producer());
		pThread.start();
		for(int i=0; i< C_THREADS; i++)
		{
			Thread cThread = new Thread(new Consumer());
			cThread.start();
		}
	}
	
	static class Producer implements Runnable {

		@Override
		public void run() {
			queueFiles(ROOT);
			try {
				bQ.put("NULL");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void queueFiles(String dirName)
		{
			File root = new File(dirName);
			
				
			for(File f : root.listFiles())
			{
				File fInner = f;
				if(fInner.isFile())
				{
					try {
						bQ.put(fInner.getAbsolutePath());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (fInner.isDirectory())
				{
					queueFiles(f.getAbsolutePath());
				}
			}
		}
		
	}

	static class Consumer  implements Runnable {

		@Override
		public void run() {
			
			try
			{
				String s = bQ.take();
			while(!s.equals("NULL"))

			{
				System.out.println(s);
				s = bQ.take();
			}
			if( s.equals("NULL"))
			{
				bQ.put("NULL");
			}
			
			
			}catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}
}
