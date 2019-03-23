package com.home.corejava.chapter06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class InnerClassTest {

	public static void main(String[] args) {

		TalkingClock c = new TalkingClock(1000, true);
		
		//regular inner class
		//c.start();
		
		//local inner class
		c.localInnerClassStart(true);
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	private int delay;
	private boolean beep;

	public TalkingClock(int delay, boolean beep) {
		this.delay = delay;
		this.beep = beep;
	}

	public void start() {
		
		TimerPrinter call = this.new TimerPrinter();
		Timer t = new Timer(delay, call);
		t.start();

	}
	
	
	/*
	 * 
	 * Local Inner Class Example
	 */
	public void localInnerClassStart(final boolean beepLocal)
	{
		  class TimePrinterLocal implements ActionListener
		   {
		      public void actionPerformed(ActionEvent event)
		      {
		          Date now = new Date();
		          System.out.println("At the tone, the time is " + now);
		          if (beepLocal) Toolkit.getDefaultToolkit().beep();
		      }
		   }

		   
		   ActionListener listener = new TimePrinterLocal();
		   Timer t = new Timer(delay, listener);
		   t.start();
	}
	
	public void anonymousClassStart(final boolean beepLocal) {
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if (beepLocal)
					Toolkit.getDefaultToolkit().beep();
			}

		};

		Timer t = new Timer(delay, listener);
		   t.start();
	}

	private class TimerPrinter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("At this time: " + now);
			//can access private field of the outer class.
			//this feature is only made possible by inner classes.
			if (TalkingClock.this.beep)
				Toolkit.getDefaultToolkit().beep();
		}

	}

}
