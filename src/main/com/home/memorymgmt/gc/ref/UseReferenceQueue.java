package com.home.memorymgmt.gc.ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Gaurav on 5/28/2017.
 */
public class UseReferenceQueue {
    public static void main(String[] args) {
        Person p = new Person();
        ReferenceQueue<Person> refQueue = new ReferenceQueue<>();
        PersonCleaner cleaner = new PersonCleaner();
        PersonWeakReference weakRef = new PersonWeakReference(p, cleaner, refQueue);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( new Runnable() {
            @Override
            public void run() {
                try {
                    PersonWeakReference wr = (PersonWeakReference) refQueue.remove();
                    wr.clean();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }});


        p = null;
        System.gc();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Press any key to continue");
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        executorService.shutdown();


        }

}

class PersonCleaner {
    public void clean()
    {
        System.out.println("cleaned");
    }
}

class PersonWeakReference extends WeakReference<Person>
{
    PersonCleaner cleaner;
    public PersonWeakReference(Person referent, PersonCleaner cleaner, ReferenceQueue<? super Person> q) {
        super(referent, q);
        this.cleaner = cleaner;
    }

    public void clean()
    {
        cleaner.clean();
    }
}

