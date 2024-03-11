package Java.Day1.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetPractice {
    public static void main(String[] args) {
        /*
         * SETS
         *      -> unordered
         *      -> only contains unique values - no duplicates
         *      -> no indexes - use iterators to loop through them
         */

        HashSet<String> names = new HashSet<>();
        names.add("Gavin");
        names.add("Robert");
        names.add("Alex");

        System.out.println(names);

        /*
         * ITERATORS
         *      -> allow you to move thorugh a collection, without a loop
         *      -> you can move through this collection at your own pace
         */

        System.out.println("ITERATOR");
        Iterator<String> nameItr = names.iterator();
        String name1 = nameItr.next();
        System.out.println(name1);
        System.out.println(nameItr.next());

        System.out.println("ITERATOR LOOP");
        Iterator<String> nameItr2 = names.iterator();
        while(nameItr2.hasNext()) {
            System.out.println(nameItr2.next());
        }

    }
}
