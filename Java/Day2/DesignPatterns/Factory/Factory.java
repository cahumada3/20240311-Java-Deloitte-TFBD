package Java.Day2.DesignPatterns.Factory;

public class Factory {

    /*
     * FACTORY
     *      you do NOT instantiate objects - the factory does
     * 
     *      you have one general class or interface with a bunch of child objects
     *          rather than your main class depennding on ALL the child object - only has to depend on the factory
     * 
     * 
     * COUPLING VS COHESION
     *      -> cohesion - refers to relationships within your class
     *              - low cohesion means that a class performs many different things
     *              - high cohesion mean that your class is focused on a specific set of tasks (we want high cohesion)
     * 
     *      -> coupling - refers to relationships between different classes
     *              - low coupling means you're dependent on a few classes (we want low coupling)
     *              - high coupling means you're dependent on many classes
     * 
     *      In code: we want HIGH cohesion and LOW coupling
     * 
     *      the point of the factory is to DECOUPLE your code - lower your coupling 
     * 
     */

     public static void main(String[] args) {
        /*
         * THIS IS HIGHLY COUPLED CODE:
         * Superhero cap = new CaptainAmerica();
         * Superhero iron = new IronMan();
         * Superhero bp = new BlackPanther();
         */

        Superhero hero = SuperheroFactory.createSuperhero("Captain America");
        hero.activateSuperpower();
        hero.sayName();
     }
    
}

class SuperheroFactory {
    public static Superhero createSuperhero(String type) {
        if(type.equals("Captain America")) {
            return new CaptainAmerica();
        }
        else if(type.equals("T'Challla")) {
            return new BlackPanther();
        }
        else if(type.equals("Iron Man")) {
            return new IronMan();
        }
        else {
            throw new IllegalArgumentException("Invalid Superhero: " + type);
        }
    }
}
