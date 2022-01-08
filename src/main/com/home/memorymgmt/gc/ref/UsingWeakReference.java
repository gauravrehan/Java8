package com.home.memorymgmt.gc.ref;


import com.home.apijava8.comparator.Person;

import java.lang.ref.WeakReference;

/**
 * Created by Gaurav on 5/28/2017.
 */
public class UsingWeakReference {
    public static void main(String[] args) {
        Person person = new Person();
        WeakReference<Person> wPerson = new WeakReference<Person>(person);
        person = null;
        Person p1 = wPerson.get();
        System.out.println(p1);
        p1 = null;

        System.gc();

        //Now since there is no strong reference left above to the Person object
        // the call to above system.gc will garbage collect the object hence below
        // call to get the strong reference from the weakreference will return null

        p1 = wPerson.get();
        System.out.println(p1);
    }
}
