package com.skillstorm;

public class AgeValidator {
    
    public boolean oldEnoughToDrive(Person person) {
        if(person.getAge() >= 16) {
            System.out.println(person.getName() + " is old enough to drive.");
            return true;
        }
        else {
            /*
             * THROWS vs THROW
             *      throw - "I am literally throwing an exception right now "
             *      throws - "Hey everybody, this method could throw an exception so be prepared to catch it"    
             */

            throw new InvalidAgeException("Must be at least 16 years old to drive");
        }
    }

    public boolean oldEnoughToVote(Person person) {
        if(person.getAge() >= 18) {
            System.out.println(person.getName() + " is old enough to vote.");
            return true;
        }
        else {
            throw new InvalidAgeException("Must be at least 18 years old to vote.");
        }
        
    }

    public boolean oldEnoughToBuyAlcohol(Person person) {
        if(person.getAge() >= 21) {
            System.out.println(person.getName() + " is old enough to purchase alcohol.");
            return true;
        }
        else {
            throw new InvalidAgeException("Must be at least 21 years old to purchase alcohol.");
        }
    }
}
