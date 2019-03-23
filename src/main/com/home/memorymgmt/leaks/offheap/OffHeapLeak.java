package com.home.memorymgmt.leaks.offheap;

/**
 * Created by Gaurav on 5/6/2017.
 */

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class OffHeapLeak {

    private static final int BUFFER_SIZE = 64 * 1024 * 1024;

    public static void main(String[] args) throws IOException
    {
        final List<ByteBuffer> buffers = new ArrayList<>();
        while (true)
        {
            buffers.add(ByteBuffer.allocate(BUFFER_SIZE));
            //below line allocates memory off heap so it will only be visible in the buffer pool plugin in the jvisualvm or in the task manager.
            buffers.add(ByteBuffer.allocateDirect(BUFFER_SIZE));

            System.out.println("Press any key to continue");
            System.in.read();
        }
    }
}
