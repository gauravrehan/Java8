package com.home.corejava.threads.callablefutures;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;


import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class GuavaExecutorServiceTest {

	public static void main(String[] args) {

		ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
		
		ListenableFuture<String> listenableFuture = service.submit(() -> {return Thread.currentThread().getName();});
		

		//Manual way of adding the listener
		listenableFuture.addListener(() -> {
			
			try {
				System.out.println(Thread.currentThread().getName());
				String result = listenableFuture.get();
				System.out.println(result);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}, service);
		
		/*
		 * This is the correct way to add the callbacks
		 * 
		Futures.addCallback(listenableFuture, new FutureCallback<String>(){
			@Override
			public void onSuccess(String result) {
				System.out.println(Thread.currentThread().getName());
				System.out.println("Sucessful callback execution result: "+ result);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println(t.getMessage());
			}
			
		});
		
		
		
		try {
			System.out.println(listenableFuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		service.shutdown();
	}

}
