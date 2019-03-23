package com.home.corejava.chapter06;

 import java.lang.reflect.*;
 import java.util.*;
 import java.io.Serializable;
/**
 Java Proxy
 */
public class ProxyTest
{
    public static void main(String[] args)
    {
        Object[] elements = new Object[1000];
        // Per classloader and order list of interaces there is just one proxy class type generated. if we
        // even change the order of the interfaces in the list of interfaces while creating the proxy object,
        // the proxy class type generated is different. To get the proxy class type name generated for an ordered set
        // of interfaces per class loader:
        // Class proxyClass = Proxy.getProxyClass(null, interfaces);
        // System.out.println(proxyClass);

        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < elements.length; i++)
        {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class } , handler);
            elements[i] = proxy;

        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) System.out.println(elements[result]);
    }
}

/**
 * An invocation handler that prints out the method name and parameters, then
 * invokes the original method
 */
class TraceHandler implements InvocationHandler
{
    private Object target;

    /**
     * Constructs a TraceHandler
     * @param t the implicit parameter of the method call
     */
    public TraceHandler(Object t)
    {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
    {
        //
        //Below line will give stackoverflow error. Why?
        //
        // System.out.println(proxy);
        // print implicit argument
        System.out.print(target);
        // print method name
        System.out.print("." + m.getName() + "(");
        // print explicit arguments
        if (args != null)
        {
            for (int i = 0; i < args.length; i++)
            {
                System.out.print(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // invoke actual method
        return m.invoke(target, args);
    }
}
