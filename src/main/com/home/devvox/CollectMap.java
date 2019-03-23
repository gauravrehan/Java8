package com.home.devvox;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * Created by richa on 1/9/2017.
 */
public class CollectMap {

    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {

        List<Person> people = createPeople();

        //create a Map with name and age as key, and the person object as the value as value.
        //using toMap and then telling it how to construct the key and values
        System.out.println(
                people.stream()
                        .collect(toMap(
                                person -> person.getName() + "-" + person.getAge(),
                                person -> person)));



        //create a Map with name as key, and then the value is going to be a list with people
        // having the same name.
        //Notice the use of groupingby
        //Notice that by using groupingby, the key is told how it has to be done but the list of person as value is
//        auto assumed ?
        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName)));

//        What if as the value i don't want the person objects in the list but instead i want all the ages in that list

        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName,
                                mapping(Person::getAge, toList()))));


    }
}
