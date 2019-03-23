package com.home.generics;

public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        System.out.println("T: " + t.getClass().getName());
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.get();
        //integerBox.inspect("some text"); // error: this is still String!
        integerBox.inspect(Double.valueOf(34.432)); // error: this is still String!

        Box bRaw = integerBox;

    }
}