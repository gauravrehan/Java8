package com.home.corejava.chapter06;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;


public class LambdaTest {
	
	public static void main(String[] args)
	{
		List<Person> persons = new ArrayList<>();
		//persons.add(new Person());
		persons.add(new Person("Gaurav Rehan", Sex.MALE, 34));
		persons.add(new Person("Richa Rehan", Sex.FEMALE, 29));
		persons.add(new Person("Aarav Rehan", Sex.MALE, 06));
		persons.add(new Person("Amit Gulati", Sex.MALE, 26));
		persons.add(new Person("Nidhi Gulati", Sex.FEMALE, 22));
		
		//Now let us print the name of the persons who are above age 22
		printPersonOlderthanAge(persons, 22);
		
		//Lets use predicate for doing the same
		printPersonWhenSomeConditionMet(persons, p -> p.getAge() > 30);
		
		//Now lets try to tell what to do when condition is met outside of the utility function
		printPersonWhenSomeConditionMet(persons, p -> p.getAge() > 30, p -> p.printPerson());
		
		//Lets try to use method reference
		printPersonWhenSomeConditionMet(persons, p -> p.getAge() > 30, Person::printPerson);
		
		//Lets try to print what we want instead of hardcoded value
		printPersonWhenSomeConditionMet(persons, p -> p.getAge() > 30, p -> p.name, s -> System.out.println(s));
		
		//Further generic method invocation processElements
		processElements(persons, p -> p.getAge() < 10, p -> p.name, s -> System.out.println(s));
		
		//finally lets use aggregate operations
		persons.stream().filter(p -> p.getAge() <= 25).map(p -> p.name).forEach(n -> System.out.println(n));
		
	}


	static void printPersonOlderthanAge(List<Person> persons, int age)
	{
		for(Person p : persons)
		{
			if(p.getAge() > age)
			{
				p.printPerson();
			}
		}
	}
	
	static void printPersonWhenSomeConditionMet(List<Person> persons, Predicate<Person> predicate)
	{
		for(Person p : persons)
		{
			if(predicate.test(p))
			{
				p.printPerson();
			}
		}
	}

	static void printPersonWhenSomeConditionMet(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer)
	{
		for(Person p : persons)
		{
			if(predicate.test(p))
			{
				consumer.accept(p);
			}
		}
	}
	
	static void printPersonWhenSomeConditionMet(List<Person> persons, Predicate<Person> predicate, Function<Person, String> function, Consumer<String> consumer)
	{
		for(Person p : persons)
		{
			if(predicate.test(p))
			{
				String value = function.apply(p);
				consumer.accept(value);
			}
		}
	}
	
	static <X,Y> void processElements(Iterable<X> iterable, Predicate<X> predicate, Function<X,Y> function, Consumer<Y> consumer)
	{
		for(X x : iterable)
		{
			if( predicate.test(x))
			{
				Y y = function.apply(x);
				consumer.accept(y);
			}
		}
	}
	
	
	
	enum Sex {
        MALE, FEMALE
    }

	
	
	static class Person {
	    
	    String name;
	    Sex gender;
	    int age;
	    
	    public int getAge() {
	        return age;
	    }

	    public void printPerson() {
	        System.out.println(name + " " + gender.name() + " " + age);
	    }
	    
	    public Person(String name, Sex gender, int age)
	    {
	    	this.name = name;
	    	this.gender = gender;
	    	this.age = age;
	    }
	}
}