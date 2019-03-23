package com.home.corejava.chapter06;

import com.home.corejava.chapter05.Employee;

public class EmployeeComparable extends Employee implements Comparable<Employee>, Cloneable {

	public EmployeeComparable(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		if(getClass() != o.getClass()) throw new ClassCastException();
			
		return Double.compare(this.getSalary(), o.getSalary());
	}
	
	@Override
	public EmployeeComparable clone() throws CloneNotSupportedException
	{
		//shallow cloning
		//return (EmployeeComparable) super.clone();
		
		//deep cloning
		EmployeeComparable clone = (EmployeeComparable) super.clone();
		clone.setHireDay((java.util.Date)clone.getHireDay().clone());
		return clone;
	}

}
