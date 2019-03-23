package com.home.memorymgmt.gc.tools;

import java.util.Random;

/**
 * Created by Gaurav on 5/28/2017.
 */
public class JstatAllocationOverwrite {

    public static void main(String[] args) throws InterruptedException{
        int arraySize = 1000000;
        GCMe[] gcme = new GCMe[arraySize];

        int count = 0;
        Random rnd = new Random();
        while(true)
        {
            gcme[rnd.nextInt(arraySize)] = new GCMe();
            if(count % 1000000 == 0)
                System.out.print(".");
            count++;
           // Thread.sleep(1);
        }
    }
}

class GCMe {
    long a;
    long aa;
    long aaa;
    long aaaa;
    long aaaaa;
    long aaaaaa;
    long aaaaaaa;
    long aaaaaaaa;
    long aaaaaaaaa;
    long aaaaaaaaaa;
    long aaaaaaaaaaa;
    long aaaaaaaaaaaa;
    long aaaaaaaaaaaaa;
    long aaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaaaa;
    long aaaaaaaaaaaaaaaaaaaa;
}
