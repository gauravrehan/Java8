package com.home.memorymgmt.gc.ref;

import java.util.Date;
import java.util.WeakHashMap;

/**
 * Created by Gaurav on 5/28/2017.
 *
 * In this code below the key is gone will get printed as the gc will
 * garbage collect the gaureha key and its associated metadata object as there
 * is no strong ref left to gaureha key.
 */
public class UseWeakHashMap {

    public static void main(String[] args) {
        WeakHashMap<Person, PersonMetadata> weakMap = new WeakHashMap<>();
        Person gaureha = new Person();
        weakMap.put(gaureha, new PersonMetadata());

        PersonMetadata p = weakMap.get(gaureha);
        System.out.println(p);

        gaureha = null;
        System.gc();

        if( weakMap.containsValue(p))
        {
            System.out.println("Still contains key");
        } else
        {
            System.out.println("Key is gone");
        }
    }
}

final class Person {}


class PersonMetadata {
    Date date;

    PersonMetadata(){
        date = new Date();
    }

    @Override
    public String toString()
    {
        return getClass().getName() + " {date=" + date + "}";
    }

}
