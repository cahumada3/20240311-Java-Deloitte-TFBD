package com.skillstorm.hellospringboot.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Car implements Vehicle, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {
    private Engine engine;

    // for lifecycle
    private String beanName;
    private ApplicationContext context;

    public Car() {
        System.out.println("***Constructor: Car() ***");
    }

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("***Constructor: Car(Engine engine) ***");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void drive() {
        this.engine.run();
    }
    
    /*
     * SPRING LIFECYCLE METHODS
     */

    /*
     * ApplicationContextAware 
     *      - obtains a reference to the application context
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println("Car - setAppContext() - " + applicationContext);
    }

    /*
     * BeanNameAware
     *      - allows beans to be aware of their own bean name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("Car - setBeanName() - " + name);
    }

    /*
     * InitializingBean
     *      this is the default init method
     *      only occurs AFTER dependency injection
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car - afterPropertiesSet()");
    }

    /*
     * DisposableBean
     *      this destroys your bean - is the default method
     *          the opposite of init
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Car - destroy()");
    }
    
}
