package Java.Day2.MultiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPractice {
    /*
     * every thread has its own stack
     *      so thing like methods and instance variables, each will have its own copy of 
     * 
     * volatile - synchronization across threads
     *              wont block other threads from manipulating the variable
     *              make threads volatile when you want to make sure other threads dont have to wait
     * 
     * static - mean that theres only 1 reference in memory
     */
    private static volatile int count = 0;

    /*
     * ATOMIC VALUES
     *      basically mean "all at once" or "all or none"
     * 
     *      AtomicInteger, AtomicDouble, etc.
     *          creates Thread-safe version of the primitive type
     * 
     *      *fun fact*
     *         all methods are atomic by default 
     */
    
    private static AtomicInteger atomicCount = new AtomicInteger(0);

    public static void increment() {
        count++;
        atomicCount.incrementAndGet(); // ++atomicCount
        //atomicCount.getAndIncrement(); // atomicCount++
    }

    public static void main(String[] args) {
        CustomThread t1 = new CustomThread(100000000);
        CustomThread t2 = new CustomThread(100000000);

        t1.start();
        t2.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //System.out.println("The total count is " + count);

        try {
            // tellilng main to wait for these threads to finish
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The total count is " + count);
        System.out.println("The total atomicCount is " + atomicCount);
    }
}

/*
 * Concurrency Issues
 *      lost update - when a variable is updated, but then changed immediately after by something else
 */

class CustomThread extends Thread {
    private int loopAmount;

    public CustomThread(int loopAmount) {
        this.loopAmount = loopAmount;
    }

    @Override
    public void run() {
        for(int i = 0; i < loopAmount; i++) {
            //incrementing count and atomicCount
            ThreadPractice.increment();
        }
    }
} 
