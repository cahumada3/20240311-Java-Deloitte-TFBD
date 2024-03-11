package Java.Day1.Collections;

import Java.Day1.FourPillars.Car;
import Java.Day1.FourPillars.Segway;
import Java.Day1.FourPillars.Vehicle;

public class ArrayPractice {
    public static void main(String[] args) {
        
        /*
         * ARRAYS
         *      -> store data in consecutive memory addresses
         *      -> access through each address using indexes
         *      -> indexes start at 0
         *      -> use square brackets to access an index
         * 
         */

         int[] numbers1 = {1, 2, 3}; // creates 3 filled memory locations 

         int numbers2[] = new int[3]; // array with 3 spots allocated but no real values

         System.out.println(numbers1);
         System.out.println(numbers2);

         int num = numbers1[2];
         System.out.println(num); // prints the value at index 2

         Vehicle[] vehicles = new Vehicle[2];
         vehicles[0] = new Car();
         vehicles[1] = new Segway();

         System.out.println(vehicles);


        /*
         * LOOPS
         *      -> while
         *      -> do-while
         *      -> for
         *      -> for-each
         *      -> iterators
         */

        /*
         * FOR LOOPS
         *      -> declare 3 things: iteration variable, condition, and the step
         */
        System.out.println("FOR LOOP");
        for(int i = 0; i < 3; i++) {
           numbers2[i] = numbers1[i]; 

           System.out.println("\t" + numbers2[i]);
        }

        /*
         * FOR EACH LOOPS
         *      -> similar to for loops 
         *      -> dont have access to the index, just loops through data structure
         */
        System.out.println("FOR EACH");
        // reads for integer x within numbers1
        for(int x : numbers1) {
            System.out.println("\t" + x);
        }

        /*
         * WHILE LOOPS
         *      -> loop until some condition is false
         */
        System.out.println("WHILE LOOP");
        int i = 2; 
        while(i >= 0) {
            System.out.println("\t" + numbers2[i]);

            i--;
        }

        /*
         * DO-WHILE LOOPS
         *      -> these will alwasy run once
         *      -> they will check the condition at the end
         */
        System.out.println("DO-WHILE");
        int j = 2;
        do {
            System.out.println("\t" + numbers2[j]);
            j--;
        }
        while(j >= 0);
    }
}
