package com.home.corejavav2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E10StreamCollectorsMap {
    public static void main(String[] args) {
        List<Person> listPerson = new ArrayList<>();
        Person p1 = new Person();
        p1.setId("01");
        p1.setName("Gaurav");
        listPerson.add(p1);
        Person p2 = new Person();
        p2.setId("02");
        p2.setName("Richa");
        listPerson.add(p2);

        //third lambda in the end handles the conflict.
        //we are saying that if there is a conflict use the existing value instead of new value.
        //forth param tells which type of map we want to use
        Map<String, Person> mapPerson = listPerson.stream().collect(
                Collectors.toMap(Person::getId,
                        Function.identity(),
                        (existingVal, newVal) -> existingVal,
                        TreeMap::new));
        System.out.println(mapPerson);



    }

    static class Person{
        String id;
        String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
