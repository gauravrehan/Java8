package com.home.corejavav2.colloctionsToStreams.M03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gaurav Rehan
 */
public class MainAPICollectionMap {

    public static void main(String[] args) {

        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);
        Person p7 = new Person("Amitabh", 67);

        /*
        Note: List.of and Arrays.asList both return immutable list which we cannot modify.
        Since I am demostrating removeIf, I am creating a new List instance out of immutable list
         */
        List<Person> pAll = new ArrayList(List.of(p1, p2, p3, p4, p5, p6, p7));

        // New function added in java 8
        pAll.removeIf(p -> p.getName().equalsIgnoreCase("amitabh"));
        //New function added in java 8
        pAll.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getAge()));
        //we can chain the comparators
        pAll.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName).reversed());

        pAll.forEach(System.out::println);

        
        City newYork = new City("New York");
        City shanghai = new City("Shanghai");
        City paris = new City("Paris");
        
        Map<City, List<Person>> map = new HashMap<>();

        //getOrDefault: if the value is present then it is returned.
        //if not present then empty list is what we are returning here.
        map.getOrDefault(newYork, Collections.EMPTY_LIST);

        //put a new array list if paris is absent
        map.putIfAbsent(paris, new ArrayList<>());
        map.get(paris).add(p1);

        //we can merge the above two calls into a single call by using computeIfAbsent
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);
    
        System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from New York : " + map.getOrDefault(newYork, Collections.EMPTY_LIST));
        
        Map<City, List<Person>> map1 = new HashMap<>();
        map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
        map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);
        
        System.out.println("Map 1");
        map1.forEach((city, people) -> System.out.println(city + " : " + people));

        
        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);
        
        System.out.println("Map 2");
        map2.forEach((city, people) -> System.out.println(city + " : " + people));

        map2.forEach(
                (city, people) -> {
                    map1.merge(
                            city, people, 
                            (peopleFromMap1, peopleFromMap2) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            });
                }
        );
        
        System.out.println("Merged map1 ");
        map1.forEach(
                (city, people) -> System.out.println(city + " : " + people)
        );
    }
}
