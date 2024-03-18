package com.skillstorm.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloSpringBootApplication {

	/*
	 * @SpringBootApplication is a combo of three annotations:
	 * 		@Configuration - specifies that a class will be a configuration class - more specifically this will
	 * 						 be a class that has beans that Spring needs to managae
	 * 		@ComponentScan - searches your package for any class annotated with @Component and make beans for those components 
	 * 		@EnableAutoConfiguration - tells spring boot to auto-configure the app context with things that we need (like a server for a webapp)
	 */

	public static void main(String[] args) {
		/*
		 * APPLICATION CONTEXT
		 * 		starts up yout IoC container
		 * 		where your beans live
		 */
		ApplicationContext context = SpringApplication.run(HelloSpringBootApplication.class, args);

		
	}

}
