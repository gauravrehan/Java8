package com.home.corejava.misc;

/**
 * Created by Gaurav on 5/6/2017.
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().sleep(200000000);
        System.out.println("Exited.");
    }
}
