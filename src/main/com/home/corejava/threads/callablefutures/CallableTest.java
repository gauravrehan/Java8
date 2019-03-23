package com.home.corejava.threads.callablefutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		Callable<String> myCallable = () -> {Thread.sleep(1000); return Thread.currentThread().getName();};
		List<Future<String>> results = new ArrayList<Future<String>>();
		ExecutorService executors = Executors.newFixedThreadPool(10);
		for(int i = 0; i< 100; i++)
		{
			Future<String> fut = executors.submit(myCallable);
			results.add(fut);
		}
		
		for(Future<String> future : results)
		{
			System.out.println(future.get());
		}
		
		executors.shutdown();
		
	}
}
