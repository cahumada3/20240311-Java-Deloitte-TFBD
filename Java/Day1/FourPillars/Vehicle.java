package Java.Day1.FourPillars;

/*
 * ABSTRACTION
 *      -> a class that has abstract methods
 *      -> can NOT be initialized
 *      -> uses the extends keyword 
 */

public class Vehicle implements Driveable {

    private String type;
    private int numWheels;

    public Vehicle() {

    }

    public Vehicle(String type, int numWheels) {
        this.type = type;
        this.numWheels = numWheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        if(numWheels >= 0) {
            this.numWheels = numWheels;
        }
    }

    @Override
    public void drive() {
    }

    //dont have to implement abstract methods from parents inside of abstract class
    //public abstract void drive();
    
}
