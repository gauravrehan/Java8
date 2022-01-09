package com.home.apijava8.predicate;

import static com.home.apijava8.predicate.Predicate.isEqualTo;

public class MainPredicate {

    public static void main(String[] args) {

        Predicate<String> p1 = s -> s.length() < 20;

        System.out.println(p1.test("Yahoo"));

        Predicate<String> p2 = s-> s.length() > 5;

        Predicate<String> pAnd = p1.and(p2);

        Predicate<String> pOr = p1.Or(p2);

        Predicate<String> pisEqualTo = Predicate.isEqualTo("Yes");
    }


}
