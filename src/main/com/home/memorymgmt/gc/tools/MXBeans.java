package com.home.memorymgmt.gc.tools;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by Gaurav on 5/22/2017.
 * Run this app with different JVM GC options and see all the collector details in console
 * -XX:+UseSerialGC
 * -XX:+UseParNewGC
 * -XX:+UseParallelGC
 * -XX:+UseParallelOldGC
 * -XX:+UseConcMarkSweepGC
 * -XX:+UseG1GC
 */
public class MXBeans {

    public static void main(String[] args) {
        List<GarbageCollectorMXBean> mbeans = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean mbean : mbeans)
        {
            System.out.println("Name: " + mbean.getName());
            System.out.println("Number of collections: " + mbean.getCollectionCount());
            System.out.println("Collection time: " + mbean.getCollectionTime() + " ms");
            System.out.println("Pool Names");
            for(String pool : mbean.getMemoryPoolNames())
            {
                System.out.println("Pool Name: " + pool);
            }

        }
    }

}
