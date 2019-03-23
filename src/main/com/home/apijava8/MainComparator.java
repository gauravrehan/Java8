package com.home.apijava8;

/**
 * Created by richa on 11/28/2016.
 */
public class MainComparator {

    public static void main(String... args)
    {

        /*
        If i have to sort a collection of Person objects based on age, first name last name,
        i have to create appropriate comparators and that causes the code to look quite verbose.
        We can make use of interface static function to allow us to pass the attribute for comparing as
        lambda expression.

         */

        /*
        Old way
         */
        Comparator<Person> c1 = (p1, p2) -> -1;
        Comparator<Person> comAge = (p1, p2) -> p1.getAge() - p2.getAge();
        Comparator<Person> comFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
        Comparator<Person> comLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

        /*
        Java 8 way - phase 1
         */
        Comparator<Person> comparatorPerson = Comparator.comparing(Person::getAge);
        Comparator<Person> comparatorPersonLastName = Comparator.comparing(Person::getLastName);

        /*
        Java 8 way - phase 2 - allows for chaining of Comparators
         */

        Comparator<Person> comparePersonAgeLastName = Comparator.comparing(Person::getAge)
                .thenComparing(Person::getLastName);

    }
}
