package com.home.apijava8.predicate;

import com.sun.org.apache.xpath.internal.operations.String;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);


    public default Predicate<T> and(Predicate<T> p2)
    {
        return t -> test(t) && p2.test(t);
    }

    public default Predicate<T> Or(Predicate<T> p2)
    {
        return t -> test(t) || p2.test(t);
    }

    public static <U> Predicate<U> isEqualTo(U other)
    {
        return s -> s.equals(other);
    }
}
