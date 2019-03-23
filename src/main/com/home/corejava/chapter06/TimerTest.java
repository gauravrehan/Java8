package com.home.corejava.chapter06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TimerTest {
	
	public static void main(String[] args)
	{
		Timer timer = new Timer(1000, new TimePrinter());
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}

class TimePrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Date now = new Date();
		System.out.println("At this time: " + now);
		Toolkit.getDefaultToolkit().beep();
		
	}
	
}

