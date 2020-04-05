package com.home.corejavav2.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class E11StreamGroupingBy {
    public static void main(String[] args) {

        List<Person> listPerson = new ArrayList<>();
        Person p1 = new Person();
        p1.setId("01");
        p1.setName("Gaurav");p1.setAge(10);
        listPerson.add(p1);
        Person p2 = new Person();
        p2.setId("02");
        p2.setName("Richa");p2.setAge(10);
        listPerson.add(p2);
        Person p3 = new Person();
        p3.setId("02");
        p3.setName("Aarav");p3.setAge(1);
        listPerson.add(p3);

        //if we want Map<String, List<Person>> with grouping based on id
        Map<String, List<Person>> mapPersonList = listPerson.stream()
                .collect(Collectors.groupingBy(Person::getId, toList()));
        System.out.println(mapPersonList);


        //if we want Map<String, Set<Person>> with grouping based on id
        Map<String, Set<Person>> mapPersonSet = listPerson.stream()
        .collect(Collectors.groupingBy(Person::getId, toSet()));
        System.out.println(mapPersonSet);

        //if we want Map<String, Long> where long is the count of persons having same id
        Map<String, Long> mapPersonCount = listPerson.stream()
                .collect(Collectors.groupingBy(Person::getId, counting()));
        System.out.println(mapPersonCount);


        //if we want Map<String, Integer> where int is the sum of all the ages of the person with same id
        Map<String, Integer> mapPersonSummingAges = listPerson.stream()
                .collect(Collectors.groupingBy(Person::getId, summingInt(Person::getAge)));
        System.out.println(mapPersonSummingAges );


        //similarly there are maxBy, minBy available to choose. in that it takes Comparator.comparing(on what to compare) in place of summingInt


    }

    static class Person{
        String id;
        String name;
        int age;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
