package com.home.corejava.chapter06;

public class CloningMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeComparable original = new EmployeeComparable("Gaurav Rehan" , 1.0, 2013, 4, 1);
		try {
			EmployeeComparable copy = original.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
