package Java.Day2.MultiThreading;

public class MultiThreadingIntro {
    /*
     * MULTI-THREADING
     *      -> splitting different tasks pnto multiple threads to be done concurrently
     *      -> by default we have a single Main thread that gets run
     * 
     *      -> Doing laundry
     *              washer -> dryer -> fold
     *              no sense in waiting for one load to be folded before putting another load in the washer
     * 
     *      -> trade-off: performance speed vs power usage 
     *      
     *      THREAD STATES
     *          1. NEW - created a new Thread, but it hasn't yet start (new Thread())
     *          2. RUNNABLE - thread has started (thread.start())
     *          3. BLOCKED - thread is waiting on some lock before continuing
     *          4. WAITING - thead is waiting indefinitely (thread.join() or thread.wait())
     *          5. TIMED-WAITING - thread waiting for a specified amount of time (thread.join(3000))
     *          6. TERMINATED - thread has finsihed
     * 
     */
    public static void main(String[] args) {

        RunnableTask task1 = new RunnableTask("Task 1");
        RunnableTask task2 = new RunnableTask("Task 2");
        RunnableTask task3 = new RunnableTask("Task 3");

        Thread thread1 = new Thread(task1);
        Thread thread2= new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
        

        /*
         * RUNNABLE INTERFACE
         *      -> a functional interface for defining how a thread will run
         *          -> a funcional interface is just an interface with 1 mthod (more on these later)
         * 
         *      Why would you use a Runnable Interface over the Thread class?
         *          Runnable interface allows you to implement multiple interfaces and extend any other classes
         *          Extending Thread class only lets you extend that one class
         * 
         */
    }
}

class RunnableTask implements Runnable {

    private String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    // this is where you're going to define what the thread will do while its running
    @Override
    public void run() {
        System.out.println("Task" + taskName + "is running in the Thread" 
                            + Thread.currentThread().getName());
                            
    }

}
