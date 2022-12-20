package com.home.corejavav2.collectorsOptionalsDataProcessing.M01;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.home.corejavav2.collectorsOptionalsDataProcessing.M01.model.Person;


/**
 *
 * @author Gaurav Rehan
 */
public class PersonSpliterator implements Spliterator<Person> {
    private final Spliterator<String> lineSpliterator;
    private String name;
    private int age;
    private String city;

    public PersonSpliterator(Spliterator<String> lineSpliterator) {
        this.lineSpliterator = lineSpliterator ;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        if (this.lineSpliterator.tryAdvance(line -> this.name = line) &&
            this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
            this.lineSpliterator.tryAdvance(line -> this.city = line)) {
            
            Person p = new Person(name, age, city);
            action.accept(p);
            return true;
        } else {
            return false;
        }
    }

    //trySplit is required only for the cases where we may expect to call parallelStream.
    @Override
    public Spliterator<Person> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lineSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return lineSpliterator.characteristics();
    }
}
