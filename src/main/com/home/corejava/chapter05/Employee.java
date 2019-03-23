package com.home.corejava.chapter05;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {

	private String name;
	private double salary;
	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	private Date hireDay;

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		
		GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);
		hireDay = gc.getTime();
	}

	public void raiseSalary(double percent) {
		double raise = percent * salary / 100;
		salary += raise;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public boolean equals(Object otherObject) {
		// a quick test to see if the objects are identical
		if (this == otherObject)
			return true;

		// must return false if the explicit parameter is null
		if (otherObject == null)
			return false;

		// if the classes don't match, they can't be equal
		if (getClass() != otherObject.getClass())
			return false;

		// now we know otherObject is a non-null Employee
		Employee other = (Employee) otherObject;

		// test whether the fields have identical values
		return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
	}

	public int hashCode() {
		return Objects.hash(name, salary, hireDay);
	}

	public String toString() {
		return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}
}