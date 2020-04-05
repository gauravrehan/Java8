package com.home.corejavav2.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class E08StreamOptional {
    public static void main(String[] args) {

        Stream<String> words3  = Stream.of("gentle1", "black1", "yellow1", "black1");
        Optional<String> findAnytString = words3.parallel().filter(s -> s.equalsIgnoreCase("gentle1")).findAny();
        //if no value set in optional then "" is returned
        System.out.println(findAnytString.orElse(""));
        //if no value set a supplier is called
        findAnytString.orElseGet(() -> "test".toString());
        //if no  value and we want to throw exception
        findAnytString.orElseThrow(IllegalStateException::new);


        Optional<String> valueOpt = Optional.<String>ofNullable("VALUE");
        //Consuming optionals. if value is present it is passed to the consumer. This isPresent doesn't return anything
        valueOpt.ifPresent(System.out::println);

        //to get return value, use Optional.map. this return an optional<Boolean> to signify the result of add
        List<String> list = new ArrayList<>();
        Optional<Boolean> isAdded = valueOpt.map(list::add);





    }
}
