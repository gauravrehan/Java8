package com.home.apijava8.comparator;


import java.util.function.Function;

public class MainComparator {

    public static void main(String... args)
    {

        Comparator<Person> cmpAge = (person1, person2) -> person1.getAge() - person2.getAge();
        Comparator<Person> cmpFirstName = (person1, person2) -> person1.getFirstName().compareTo(person2.getFirstName());
        Comparator<Person> cmpLastName = (person1, person2) -> person1.getLastName().compareTo(person2.getLastName());



        Comparator<Person> cmpPersonfAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonfFirstName = Comparator.comparing(Person::getFirstName);

        //Comparator<Person> cmpPersonMultiple = cmpPersonfAge.thenComparing(cmpPersonfFirstName);
        Comparator<Person> cmp= Comparator.comparing(Person::getAge).thenComparing(Person::getLastName).thenComparing(Person::getFirstName);

    }
}
