package Java.Day1.FourPillars;

/*
 * INHERITANCE
 *      -> when a child class is given access to the varaibles and methods in the parent
 *      -> extends keyword for classes, can extend only one
 *      -> implements keyword for interfaces, can implement multiple
 * 
 */

public class Segway extends Vehicle{
    private String battery;

    public Segway() { 
        super(); // calls the no-arg constructor of parent
    }

    public Segway(String type, int numWheels, String battery) {
        super(type, numWheels); // calls the parameterized constructor of the parent

        this.battery = battery; // calls another constructor in the same class
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    @Override
    public void drive() {
        System.out.println(battery + " is used to drive");
    }

    @Override
    public String toString() {
        return "Segway [battery=" + battery + ", num of wheels=" + getNumWheels() + "]";
    }
    
}
