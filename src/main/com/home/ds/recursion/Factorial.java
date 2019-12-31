package com.home.ds.recursion;
/*
with int the factorial value will breach with n = 13
with Long the factorial value will brach with n = 21
if we want to go 21 and beyond we can use BigInteger class. this class objects are immutable.

complexity of recursive functions are usually exponentials of 2 ^ n for fiboniaci
 */
public class Factorial {
    public static void main(String[] args) {

        System.out.println("Print factorial for: " + factorial(21L));
    }
    public static Long factorial(Long n)
    {
        //System.out.println("Invoked for : " + n);
        if(n == 0)
            return 1L;

        Long val =n * factorial(n-1);
        if (val >= Long.MAX_VALUE)
            System.out.println("Long value breached at n of : " + n);

        //System.out.println("Intermediate val :" + val);
        return val;

    }

}
