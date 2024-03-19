package com.skillstorm.hellospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.skillstorm.hellospringboot.beans.Vehicle;

@SpringBootApplication
public class HelloSpringBootApplication implements CommandLineRunner {

	/*
	 * @SpringBootApplication is a combo of three annotations:
	 * 		@Configuration - specifies that a class will be a configuration class - more specifically this will
	 * 						 be a class that has beans that Spring needs to manage
	 * 		@ComponentScan - searches your package for any class annotated with @Component and make beans for those components 
	 * 		@EnableAutoConfiguration - tells spring boot to auto-configure the app context with things that we need (like a server for a webapp)
	 */

	/*
	 * @Autowired
	 * 	- another way to get your bean instead of using application context
	 */
	@Autowired
	@Qualifier("camaro")
	private Vehicle car4;

	@Autowired
	@Qualifier("tesla")
	private Vehicle car5;

	public static void main(String[] args) {
		/*
		 * APPLICATION CONTEXT
		 * 		starts up your IoC container
		 * 		where your beans live
		 */
		ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

		Vehicle car = (Vehicle) context.getBean("mustang");
		System.out.println("I'm driving a mustang!!");
		car.drive();

		Vehicle car2 = (Vehicle) context.getBean("tesla");
		System.out.println("I'm driving a tesla!!");
		car2.drive();

		Vehicle car3 = (Vehicle) context.getBean("tesla");
		car3.drive();

		System.out.println("Car1: " + car);
		System.out.println("Car2: " + car2);
		System.out.println("Car3: " + car3);
		
	}

	@Override
	public void run(String... args) throws Exception{
	/*
	 * COMMAND LINE RUNNER
	 * 		method that runs AFTER the app context is loaded
	 * 		you no longer have to call context.getBean()
	 * 
	 * 		usually used to perform some setup for an application - like loading data
	 * 		functional interface - so it could be a lambda 
	 * 
	 */
		System.out.println("I'm driving a camaro!");
		car4.drive();
	}

}
