package com.skillstorm.springaop.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;                // Simple logging facade for java - abstraction for logging frameworks
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.springaop.models.Director;

@Component
@Aspect         //tells AspectJ that this is an aspect 
public class LoggingAspect {

    /*
     * Spring Boot provides configurations for:
     *      - Log4J2 (*** dont use version 1)
     *      - Logback
     *      - Java Util Logging
     * 
     *  Logback is included with the Spring Boot Starter Dependencies
     * 
     *  Logging Levels:
     *      fatal -> error -> warn -> info -> debug -> trace
     *      set this in application.yml
     */
    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /*
     * ASPECTS
     *      Join Points - any place in your code that an aspect can insert itself into
     *              like your classes or methods 
     * 
     *      Point Cut - defined in your aspect. specifies which join point to insert itself into
     * 
     *      Advice - this is what gets executed when the aspect inserts itself
     *              its going to tell the point cut how/when to interrupt
     */

    /*
     * options for defining point cut:
     *      within() - specify a package or class
     *      execution() - when a specific method executes
     *      bean() - for a specific bean
     */
    @Pointcut("within(com.skillstorm.springaop.controllers.MovieController)")   // any method in the MovieController class is now a pointcut
    public void checkMovie() {
        /* leave empty - the code inside wont ever run */
    }

    // * wildcard means any return type 
    @Pointcut("execution(public * saveDirector(com.skillstorm.springaop.models.Director)) && args(directorToBeSaved)")
    public void checkDirector(Director directorToBeSaved) {

    }

    /*
    * Types of Advice
    *      Before - advice runs before method execution
    *      After - advice runs after method execution
    *      AfterReturning - advice runs after method execution ONLY when it returns soemthing 
    *      AfterThrowing - advice runs after method execution ONLY when it throws an exception
    *      Around - all of the above
    */

    @Before("checkMovie()")
    public void request(JoinPoint joinPoint) {
        log.debug("A request was made to {} with the argument(s): {}",
            joinPoint.getSignature(),
            Arrays.toString(joinPoint.getArgs())
        );
    }

    @AfterReturning(value = "checkMovie()", returning = "returnedData")
    public void response(JoinPoint joinPoint, Object returnedData) {
        log.debug("A response was sent from {} with the returned data: {}",
            joinPoint.getSignature().getName(),
            returnedData.toString()
        );
    }

    @Around("checkDirector(directorToBeSaved)")
    public Director logDirectors(ProceedingJoinPoint proceedingJoinPoint, Director directorToBeSaved) {
        /*
         * PROCEEDING JOIN POINT
         *      join point that has an extra method: .proceed()
         * 
         *      aspect is going to interrupt a method and do something - then that method gets executed
         *      with a proceeding join point, it WILL NOT execute that method, until you call .proceed()
         * 
         *      THESE ARE ONLY AVAILABLE ON AROUND ADVICE 
         */
        log.debug("DIRECTOR: {}", directorToBeSaved.toString());

        if(directorToBeSaved.getId() == 0) {
            try {
                proceedingJoinPoint.proceed();
            } catch(Throwable e) {
                log.error("Method could not be executed", e);
            }
            log.debug("DIRECTOR WAS CREATED");
        }
        else {
            log.debug("DIRECTOR WAS NOT CREATED - ALREADY EXISTS");
        }

        return directorToBeSaved;
    }
    
}
