package com.home.corejava.threads;

import java.text.SimpleDateFormat;
/*
 * Good article on thread local
 * http://javarevisited.blogspot.in/2012/05/how-to-use-threadlocal-in-java-benefits.html
 * 
 */
public class ThreadLocalTest {

	/*
	 * this is invoked in the thread as dateFormat.get()......
	 */
	public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	
	

}
