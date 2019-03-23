package com.home.memorymgmt.leaks.classloaders;

/**
 * Created by Gaurav on 5/6/2017.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamplePlugin2 implements Plugin {
    public static final long[] LOTS_OF_MEMORY = new long[8 * 1024 * 1024];

    private ExamplePluginLevel level = new ExamplePluginLevel();

    public void initialize() {
        level.write("HelloWorld!");
    }

    private class ExamplePluginLevel {
        public void write(String s)
        {
            System.out.println(s);
        }
    }
}


