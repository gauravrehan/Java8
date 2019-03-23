package com.home.memorymgmt.leaks.classloaders;

/**
 * Created by Gaurav on 5/6/2017.
 */

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/*
The ExamplePlugin makes use of java.util.logging that has a java bug that keeps a reference alive. hence when we keep loading the plugin, the old plugin instances remain in the memory
and are never removed by the GC. Run the app with ExamplePlugin and load the plugin multiple time and see the out of memory exception. before the error, take a heap dump and look at the
ExamplePlugin class instances getting retained in heap dump.
Run with the other two plugins and you will see that the app runs just fine. take heap dump and you will not see the instances of your plugin at all.
 */
public class ApplicationRunner {
    public static void main(final String[] args) throws Exception
    {
        //final String pluginName = "com.home.memorymgmt.leaks.classloaders.ExamplePlugin";
        final String pluginName = "com.home.memorymgmt.leaks.classloaders.ExamplePlugin2";
        //Run with second plugin and you will not see the leak.
        //final String pluginName = "com.home.memorymgmt.leaks.classloaders.ExamplePluginWithoutLeak";

        while (true)
        {
            System.out.println("Press any key to reload the plugins");
            System.in.read();

            final URL[] urls = { new File("target/classes").toURI().toURL()};
            final URLClassLoader classLoader = new URLClassLoader(urls, null);
            final Class<?> aClass = classLoader.loadClass(pluginName);
            final Object plugin = aClass.newInstance();
            aClass.getMethod("initialize").invoke(plugin);
        }
    }
}
