package com.home.corejava.threads.callablefutures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {

	public static void main(String[] args) {

		//Create a thread pool
		ExecutorService executorService = new ThreadPoolExecutor(2, 4, 5000, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		
		//fire and forget. pass runnable and forget
		executorService.execute(() -> {System.out.println(Thread.currentThread().getName());});
		
		//get result back by submitting a callable object
		Future<String> result = executorService.submit(() -> {return Thread.currentThread().getName();});
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();

	}

}
