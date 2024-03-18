package Java.Day1.FourPillars;

/*
 * POLYMORPHISM
 *      covariance - allows a child class to act in place of a parent class
 */

public class FourPillarsMain {

    //main is the starting point of your project
    public static void main(String[] args) {

        // how we print to the command line
        System.out.println("Hello World!");

        // creates a new car object
        Vehicle car = new Car("four-cylinder", "Toyota", "Tocoma", "Purple", "Car", 4 );

        // print out car using the toString() method
        System.out.println(car.toString());

        System.out.println(car.getNumWheels());

        car.drive();

        Vehicle segway = new Segway("Segway", 2, "lithium-ion");
        System.out.println(segway.toString());
        System.out.println(segway.getNumWheels());
        segway.drive();

    }
}




