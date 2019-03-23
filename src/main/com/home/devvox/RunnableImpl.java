package com.home.devvox;

import java.util.concurrent.Executors;

/**
 * Created by richa on 11/15/2016.
 */
public class RunnableImpl {

    public static void main(String[] args)
    {
        Executors.newSingleThreadExecutor().execute(getRunnable());
        Executors.newSingleThreadExecutor().execute(getRunnableLambda());
    }

    public static Runnable getRunnable()
    {
        Runnable runnable = new Runnable(){
            public void run()
            {
                int i = 0;
                while(i <= 20) {
                    System.out.println("i = " + i);
                    i++;
                }
            }
        };

        return runnable;
    }

    public static Runnable getRunnableLambda()
    {
        Runnable runnable = () -> {
            int i = 0;
            while(i <= 40) {
                System.out.println("i = " + i);
                i++;
            }
        };
        return runnable;
    }
}
