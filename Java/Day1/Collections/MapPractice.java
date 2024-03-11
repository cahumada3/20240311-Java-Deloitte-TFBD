package Java.Day1.Collections;

import java.util.HashMap;

public class MapPractice {
    public static void main(String[] args) {
        
        /*
         * MAPS
         *      -> unordered and operate on key-value pairs
         *      -> key have to be 100% unique
         *      -> value can be anything 
         * 
         * HASHMAPS
         *      -> these use hashcode() to determine index location
         *          - creates constant lookup time O(1)
         *      -> built on arrays so they do have indexes, but they dont work with them
         * 
         *      -> collisions
         *          - techinically these *shouldn't* happen
         *              but they can
         *          - happens when multiple keys have the same hashcode and get put into the
         *            same index location
         *                  java creates a linked-list at that index location
         *          - under the hood, out hashmaps are arrasy of linked-lists
         */
        HashMap<String, Animal> animalMap = new HashMap<>();

        Animal lion = new Animal("leo");
        Animal tiger = new Animal("lenny");
        Animal elephant = new Animal("lily");

        animalMap.put("lion", lion);
        animalMap.put("tiger", tiger);
        animalMap.put("elephant", elephant);

        System.out.println(animalMap.get("lion"));
        System.out.println(animalMap);

        Animal lion2 = new Animal("leonard");

        // use .put() with an existing key to modify map
        animalMap.put("lion", lion2);

        System.out.println(animalMap.get("lion"));
        System.out.println(animalMap);

        // uses keySet() or values() to loop through these
        for(String animal : animalMap.keySet()) {
            System.out.println(animal);
        }

        for(Animal animal : animalMap.values()) {
            System.out.println(animal);
        }

    }
    
}
