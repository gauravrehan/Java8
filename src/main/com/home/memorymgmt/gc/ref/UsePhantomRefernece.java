package com.home.memorymgmt.gc.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/**
 * Created by Gaurav on 5/28/2017.
 */
public class UsePhantomRefernece {
    public static void main(String[] args) {
        ReferenceQueue<Person> queue = new ReferenceQueue<>();
        ArrayList<FinalizePerson> list = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            Person p = new Person();
            people.add(p);
            list.add(new FinalizePerson(p, queue));
        }

        people = null;
        System.gc();

        for(PhantomReference<Person> ref : list)
        {
            System.out.println(ref.isEnqueued());
        }

        Reference<? extends Person> referenceFromQueue;
        while((referenceFromQueue = queue.poll()) != null)
        {
            ((FinalizePerson)referenceFromQueue).cleanup();
            referenceFromQueue.clear();
        }




    }
}

class FinalizePerson extends PhantomReference<Person>
{

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     * <p>
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public FinalizePerson(Person referent, ReferenceQueue<? super Person> q) {
        super(referent, q);
    }

    public void cleanup()
    {
        System.out.println("person is finalizing resources");
    }
}
