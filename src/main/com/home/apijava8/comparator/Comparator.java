package com.home.apijava8.comparator;

import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static <U> Comparator<U> comparing(Function<U, Comparable> fAge) {

        return (p1, p2) -> fAge.apply(p1).compareTo(fAge.apply(p2));
    }

    default Comparator<T> thenComparing(Comparator<T> cmp)
    {
        return (p1, p2) -> compare(p1, p2) == 0 ? cmp.compare(p1, p2) : compare(p1, p2);
    }

    default Comparator<T> thenComparing(Function<T, Comparable> cmp)
    {
        Comparator<T> comparator = comparing(cmp);
        return thenComparing(comparator);
    }
}
