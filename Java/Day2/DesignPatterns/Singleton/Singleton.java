package Java.Day2.DesignPatterns.Singleton;


/*
 * SINGLETONS
 *      -> when you only want ONE instance of an object
 *      -> useful when working with threads - every thread will be using the same object 
 * 
 */
public class Singleton {

    /*
     * EAGER vs LAZY LOADING
     *          eagerly loading - instantiate an object as soon as possible
     *                  faster but could resilt in unnecessary memory allocation
     * 
     *          lazily loading - only instantiate the object when it is asked for 
     *                  slow but no memory is wasted
     * 
     * 
     */
    //private static Singleton ins = new Singleton(); // eargerly loading

    private static Singleton instance;  //this is the object

    private int count = 0;

    private Singleton() { }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public static Singleton getInstance() {
        //return ins;

        // lazily loading
        if(instance == null) {
            // instantiating the object
            instance = new Singleton();
        }
        return instance;
    }
    


    
}
