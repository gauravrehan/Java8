package com.home.devvox;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by gauravrehan on 21/11/16.
 */

public class MethodReferencesImpl {


    public static void main(String[] args) {

        Person person = new Person();
        person.setDob(new Date());
        person.setName("Gaurav Rehan");

        //The ususal lambda expression way
        Function<Person, Integer> functionLambda = (Person p) -> p.getAge();

        //The method reference way of writing the above lambda expression
        Function<Person, Integer> functionMethodReference = Person::getAge;

        System.out.println("Result from the lambda expression " + functionMethodReference.apply(person));
        System.out.println("Result from the Method reference " + functionMethodReference.apply(person));

        /*
        i am a bit confused in what situation should i use the method reference. and secondly when to use class/instance var in the
        method reference definition.

        Answer:
        Is another way of writing lambda expression. makes code more readable.
        Method references improve the readability of the code.
        It doesnt really matter whether the call is static or not.



        */

        //Another example
        BinaryOperator<Integer> sumLambda = (i1, i2) -> Integer.sum(i1, i2);
        BinaryOperator<Integer> sumMethodReferences = Integer::sum;


        //Another example
        Consumer<String> printerLambda = s -> System.out.println(s);
        Consumer<String> printerMethodReferences = System.out::println;

        printerMethodReferences.accept("Method reference another example:" + sumMethodReferences.apply(21, 24));

    }


    static class Person {

        private String name;
        private Date dob;

        public void setName(String name) {
            this.name = name;
        }

        public void setDob(Date dob) {
            this.dob = dob;
        }

        public String getName() {
            return name;
        }

        public Date getDob() {
            return dob;
        }

        public int getAge() {
            //need to work on this
            return 23;
        }


    }
}