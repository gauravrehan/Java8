package com.home.apijava8;

import java.util.function.Function;

/**
 * Created by gaurav on 11/28/2016.
 */

@FunctionalInterface
public interface Comparator<T> {

    public int compare(T t1, T t2);

    public static <U> Comparator<U> comparing(Function<U, Comparable> f)
    {
        return (p1, p2) -> f.apply(p1).compareTo(f.apply(p2));
    }

    /*
    This is used for chaining at the caller side. so it has to accept the Function lambda expression.
    Use that passed function to get the Comparator using the static function.
     */
    public default Comparator<T> thenComparing(Function<T, Comparable> f)
    {
        return thenComparing(comparing(f));
    }

    /*
    Use to define the behavior of chaining.
     */
    public default Comparator<T> thenComparing(Comparator<T> comp)
    {
        return (t1, t2) -> compare(t1, t2) == 0 ? comp.compare(t1, t2) : compare(t1, t2);
    }

}
