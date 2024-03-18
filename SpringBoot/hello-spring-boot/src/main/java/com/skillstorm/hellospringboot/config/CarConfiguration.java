package com.skillstorm.hellospringboot.config;

import org.springframework.context.annotation.Configuration;

import com.skillstorm.hellospringboot.beans.Car;
import com.skillstorm.hellospringboot.beans.Engine;
import com.skillstorm.hellospringboot.beans.GasEngine;
import com.skillstorm.hellospringboot.beans.Vehicle;

@Configuration
public class CarConfiguration {

    /*
     * where we can configure our car beans
     *      telling spring boot where to get our beans from/how to initilize them
     * 
     */

    /*
     * BEANS
     *      - register beans inside teh BeanFactory
     */

    // public Vehicle gasCar() {
    //     Car car = new Car();
    //     car.setEngine(gasEngine());
    //     return car;
    // }

    public Engine gasEngine() {
        return new GasEngine();
    }
    
}
