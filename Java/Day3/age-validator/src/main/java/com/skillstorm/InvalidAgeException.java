package com.skillstorm;
    /*
     * Creating custom exceptions:
     *      - needs to extend an existing exception class
     *      - should have 'Exception' at the end of its name
     * 
     */
public class InvalidAgeException extends IllegalArgumentException {

    public InvalidAgeException() { }

    public InvalidAgeException(String message) {
        super(message);
    }
}
