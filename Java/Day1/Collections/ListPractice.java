package Java.Day1.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListPractice {

    /*
     * LISTS
     *      -> are indexed and ordered 
     *      -> Collections API in java - all lists will inherit from the List class
     *      -> ONLY WORK WITH OBJECTS
     *          - java gives you wrapper classes for primitive types
     *                  int -> Integer
     *                  double -> Double
     *                  etc.
     */
    public static void main(String[] args) {
        /*
         * ARRAY LISTS
         *      -> dynamic array - grows as you add more data to it 
         *      -> the starting cpacity is 10, unless you say otherwaise
         *      -> once it is full, it will grow by 50%
         *              10 -> 15 -> 23 etc.
         * 
         *      -> lookup O(1) with the index
         *      -> insertion is constant time at the end of the array,only if there is no resizing
         *              - if resizing, then its O(n)
         *              - if its in the middle, its O(n)
         */

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("pineapple");

        fruits.add(0, "banana"); // to insert at a specific index

        System.out.println(fruits.get(0));
        System.out.println(fruits);

        fruits.remove(0);
        System.out.println(fruits);

        System.out.println(fruits.indexOf("mango")); // returns the index location of the first instance of the object

        /*
         * LINKED-LISTS
         *      -> non-consecutive memory locations
         *      -> each node contains at least one pointer to the next node and your data at that node
         *      -> don't have indexes - lookup is O(n)
         *      -> insertion at the front is O(1)
         *          - anywhere else is O(n)
         *      -> capacity will always equal size
         *      -> java linked-lists are ALWAYS doubly linked
         *          - 2 pointers in each node, one for the next and one for the previous
         * 
         */

        LinkedList<String> names = new LinkedList<>();
        names.add("Caroline");
        names.add("Caleb");
        names.add("Waleed");

        names.remove("Caleb");

        System.out.println(names);
        System.out.println(names.get(0));

    }
    
}
