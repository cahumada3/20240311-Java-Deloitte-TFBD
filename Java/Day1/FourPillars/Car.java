package Java.Day1.FourPillars;

public class Car extends Vehicle {
    /*
     * 
     * ENCAPSULATION
     *      - wrapping up related state and behavior into a single class
     *      - we can control how that state and behvior is modified and accessed
     *          - access modifers
     *              -> public: everyone can see
     *              -> private: only the class can see
     *              -> protected: only the package can see
     * 
     */

    // properties of our class
    private String engine;
    private String make;
    private String model;
    private String color;

    // no-arg constructor
    // implicitly defined by java if you don't declare it
    public Car() {
    }

    public Car(String engine, String make, String model, String color, String type, int numWheels) {

        super(type, numWheels);

        this.engine = engine;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*
     * POLYMORPHISM
     *      -> "many forms"
     *          - helps with code reusability
     *      -> method overriding
     *          - happens at runtime
     *          - when you implement a method from the parent class in the child class
     *      -> every class inherits from the Object class
     * 
     */

    @Override // semantics - just a way to show that it is an overriden method
    public String toString() {
        return "Car [engine=" + engine + ", make=" + make + ", model=" + model + ", color=" + color + "]";
    }

    @Override
    public void drive() {
        System.out.println(engine + " is used to drive.");
    }
    
}
