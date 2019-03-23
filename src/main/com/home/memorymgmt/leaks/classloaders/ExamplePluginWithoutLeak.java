package com.home.memorymgmt.leaks.classloaders;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Gaurav on 5/6/2017.
 */
public class ExamplePluginWithoutLeak {    public static final long[] LOTS_OF_MEMORY = new long[8 * 1024 * 1024];



    public void initialize() {
        System.out.println("Hello World!");
    }


}