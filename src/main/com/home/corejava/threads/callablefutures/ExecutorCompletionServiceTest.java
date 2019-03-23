package com.home.corejava.threads.callablefutures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCompletionServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService service = Executors.newCachedThreadPool();
		ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(service);
		List<Callable<String>> callables = new ArrayList<>();
		for(Callable<String> callable : callables) completionService.submit(callable);
		
		//Advantage of using ExecutorCompletionService is that it can return you the callables
		//which have finished first. internally it maintains a blocking queue using which we 
		//can get the finished callable futures.
		
		Future<String> result = completionService.take();
		do{
			System.out.println(result.get());
			result = completionService.take();
		}
		while (result != null);
		
		
	}
}
