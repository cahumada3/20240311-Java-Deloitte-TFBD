package Java.Day2.DesignPatterns.ProducerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProducerConsumer {

/*
 * PRODUCER and CONSUMER
 *      -> one entity (usaully a thread) produces data
 *         another entity (usually a thread) that consumes data
 * 
 *      -> use multithreading in java to do this
 */
public static void main(String[] args) {
    /*
     * CONCURRENT COLLECTIONS
     *      - java.util.concurrent
     *      - thread-safe collections
     *           they will handle the synchronization for us
     * 
     */

    final Queue<Integer> buffer = new ConcurrentLinkedQueue<>(); //the size of the collection will never change
    final int CAPACITY = 5;                                      // final mean the value cannot be changes - capacity will always be 5

    Thread producerThread = new Thread(new Runnable() {
        /*
         * ANONYMOUS INNER CLASSES
         *      - a class that isnt declared but it defined 
         *      - only created with funcational interfaces
         */

        @Override
        public void run() {
            int value = 0;

            // simulating grabbing these values from somewhere and putting them on the queue
            while(true) {
                if(buffer.size() < CAPACITY) {
                    System.out.println("Producer produces " + value);
                    buffer.add(value++);
                }
            }

        }
    });

    /*
     * LAMBDA FUCNTIONS
     *      shorthand way to implement the method of a functional interface
     */


    Thread consumerThread = new Thread((/* any parameters for the method */) -> {

        //THIS IS THE RUN METHOD FOR THE RUNNABLE CLASS

        while(true) {
            if(!buffer.isEmpty()) {
                int value = buffer.poll(); //poll() - retrieves the data at the front of the queue and removes it
                System.out.println("Consumer consumes: " + value );
            }
        }

    });

    producerThread.start();
    consumerThread.start();

}
    
}
