package com.skillstorm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

/*
 * JUNIT - unit testing framework
 *       - unit testing is testing the individual components to ensure that they work as intended
 * 
 * JUNIT ANNOTATIONS
 *      BeforeClass
 *      Before
 *      Test
 *      AfterClass
 *      After
 *      Ignore
 * 
 *      if you have multiple methods of the same annotation type, Junit does not quarentee their order
 * 
 */

public class AgeValidatorTest {
    
    static AgeValidator ageValidator;

    Person person1;
    Person person2;
    Person person3;
    Person person4;
    Person person5;

    /*
     * BeforeClass and Before Annotations
     *          thse are setup methods
     *              used initialize data you will use with in your tests
     * 
     *          BeforeClass - runs once before all the other methods
     *          Before - runs right before each test
     * 
     *          ex: BeforeClass to setup a database connectionS
     *          ex: Before to load data from the database
     * 
     */

    @BeforeClass
    // needs to be static
    public static void setupAgeValidator() {
        ageValidator = new AgeValidator();
    }

    @Before
    public void setupPeople() {
        person1 = new Person("Dexter", 12);
        person2 = new Person("Frederik", 16);
        person3 = new Person("Carlos", 17);
        person4 = new Person("Kyle", 19);
        person5 = new Person("Caleb", 65);
    }

    @Test
    public void testOldEnoughToDrive() {
        /*
         * test are either going to pass or fail
         *      tests only fail if an exception is thrown and is unhandled
         * 
         * junit uses assertion methods to throw exceptions for us - they dont return anything
         */

        try {
            assertFalse(ageValidator.oldEnoughToDrive(person1));
            assertTrue(ageValidator.oldEnoughToDrive(person2));
            assertEquals(ageValidator.oldEnoughToDrive(person3), (ageValidator.oldEnoughToDrive(person4)));
            assertTrue(ageValidator.oldEnoughToDrive(person5));
        } catch (InvalidAgeException e) {
            System.out.println("Not old enough");
        }
    }

    /*
     * instead of using try-catch, you can tell the test to expect a specific exception
     */
    @Test(expected = InvalidAgeException.class)
    public void testOldEnoughToVote() {
        assertFalse(ageValidator.oldEnoughToVote(person1));
        assertFalse(ageValidator.oldEnoughToVote(person2));
        assertNotEquals(ageValidator.oldEnoughToVote(person3), ageValidator.oldEnoughToVote(person4));
        assertTrue(ageValidator.oldEnoughToVote(person5));
    }

    @Test
    public void testOldEnoughToBuyAlcohol() {
        /*
         * assertThrows - is saying that a specific method call should throw an exception, rather than
         *                all asserts in the Test method
         */
        assertThrows(InvalidAgeException.class, new ThrowingRunnable() {
            @Override
            public void run() {
                ageValidator.oldEnoughToBuyAlcohol(person1);
            }
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToBuyAlcohol(person2);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToBuyAlcohol(person3);
        });

        assertThrows(InvalidAgeException.class, () -> {
            ageValidator.oldEnoughToBuyAlcohol(person4);
        });

        assertTrue(ageValidator.oldEnoughToBuyAlcohol(person5));
    }
}
