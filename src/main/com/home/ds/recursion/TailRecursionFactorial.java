package com.home.ds.recursion;

/*
this tail implementation doesnot cause stackoverflow exeption because the accumalator passes on the
accumalated value to the recursive call.
Java is not able to optimize the tail recursion and uses stack and cause stackoverflow exception.
Functional programming languages are able to honor tail recursion.
 */
public class TailRecursionFactorial {

    public static void main(String[] args) {

    }
    public static int factoiral(int n)
    {
        return factorial(n, 1);
    }
    private static int factorial(int n, int result)
    {
        if (n == 0)
            return result;
        return factorial(n-1, n * result);
    }
}
