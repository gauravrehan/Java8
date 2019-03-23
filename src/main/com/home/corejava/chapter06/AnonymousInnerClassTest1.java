package com.home.corejava.chapter06;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;



public class AnonymousInnerClassTest1 {








   public static void main(String[] args)
   {
	   TalkingClockAnonymous clock = new TalkingClockAnonymous();
      clock.start(1000, true);

      // keep program running until user selects "Ok"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}

/**
 * A clock that prints the time in regular intervals.
 */
 class TalkingClockAnonymous
{
   
   /**
    * Constructs a talking clock
    * @param interval the interval between messages (in milliseconds)
    * @param beep true if the clock should beep
    */
   public TalkingClockAnonymous()
   {
     
   }

   /**
    * Starts the clock.
    */
   public void start(int interval, boolean beep)
   {
	  
      ActionListener listener = new ActionListener(){
    	  @Override
    	  public void actionPerformed(ActionEvent event)
	      {
	         Date now = new Date();
	         
	         System.out.println("At the tone, the time is " + now);
	         if (beep) Toolkit.getDefaultToolkit().beep();
	      }
      };
      Timer t = new Timer(interval, listener);
      t.start();
   }
   
}
