package com.home.corejava.threads;

public class DeadlockTest {
	
	
	    static class Friend {
	        private final String name;
	        public Friend(String name) {
	            this.name = name;
	        }
	        public String getName() {
	            return this.name;
	        }
	        public synchronized void bow(Friend bower) {
	            System.out.format("%s - %s: %s"
	                + "  has bowed to me!%n", Thread.currentThread().getName(),  
	                this.name, bower.getName());
	            System.out.format("%s - %s%n", Thread.currentThread().getName(), " invoking bowBack on " + bower.name);
	            bower.bowBack(this);
	        }
	        public synchronized void bowBack(Friend bower) {
	            System.out.format("%s - %s: %s"
	                + " has bowed back to me!%n",Thread.currentThread().getName(),
	                this.name, bower.getName());
	        }
	    }
	    
	    public DeadlockTest() throws InterruptedException
	    {
	    	   Friend alphonse =
	  	            new Friend("Alphonse");
	  	         Friend gaston =
	  	            new Friend("Gaston");
	  	        new Thread(new Runnable() {
	  	            public void run() { alphonse.bow(gaston); }
	  	        }).start();
	  	        //Thread.sleep(100);
	  	        new Thread(new Runnable() {
	  	            public void run() { gaston.bow(alphonse); }
	  	        }).start();
	    }
	    

	    public static void main(String[] args) throws InterruptedException {
	      new DeadlockTest();
	    }
	}


