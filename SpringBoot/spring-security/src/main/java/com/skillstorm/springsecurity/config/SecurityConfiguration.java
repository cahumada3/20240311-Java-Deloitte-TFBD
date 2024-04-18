package com.skillstorm.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)    // allow for AOP security checks (prePostEnabled is true by default)
public class SecurityConfiguration {

    /**
     * 
     * be careful about doing research with spring security
     *      many methods have been deprecated
     * 
     *          SecurityConfiguration class used to extend WebSecurityConfigureAdapter (this is deprecated now)
     * 
     *          authorizeRequests have been deprecated - authorizeHttpRequests is used instead
     * 
     *          antMatchers and mvcMatchers have been deprecated - requestMatchers is used instead
     *              requestMatchers offers different flavors to facilitate various ways of restricting requests that were supported by the deprecated methods
     * 
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        // using the httpSecurity object to configure which endpoints require authentication/authorization
        http
            .authorizeHttpRequests((authorizeHttpRequests) -> 

                authorizeHttpRequests
                    .requestMatchers("users/hello").permitAll() // allow all access to /users/hello endpoint without authentication
                    .requestMatchers("users/private_info").authenticated()  // authentication required to make GET request to /users/private_info
                    .requestMatchers(HttpMethod.POST, "/users/register").authenticated() 

                    .requestMatchers(HttpMethod.GET, "/movies/**").authenticated()
                    .requestMatchers(HttpMethod.POST, "/movies/**").authenticated()  
                    .requestMatchers(HttpMethod.DELETE, "/movies/**").hasRole("ADMIN")      // only an admin user can delete movies
        )
        //.formLogin(Customizer.withDefaults())
        .httpBasic(withDefaults());     //use Basic Authentication instead of formLogin

        /**
         * Cross Site Request Forgery
         *      when someone is trying to be you while you are logged in
         * 
         *  Spring Security handles this by using a Synchronizer Token pattern
         *      - when you do a GET request, the server will generate a token and return it
         *      - then in every future rrequest that modifies data (Put, Post, Delete, etc.) you need to include the token in the header 
         * 
         *  can be disabled with csrf().disable() but this is BAD PRACTICE
         */

        http.csrf((csrf) -> 
            // the CSRF filter will check for the csrf token on every modifying reques, except to /users/register

            // this will generate and return a XSRF-TOKEN cookie with a generated value
            // need to include a X-XSRF-TOKEN in your headers with the matching genertated value to validate the user
            csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).ignoringRequestMatchers("/users/register", "/users/register/admin")
        ); 
    
        return http.build();
    }

    /** 
     * using BCrypt to encode passwords
     * BCypt uses hashing so there is a predicatble result each time
     *          it will hash the number of times that you specify (cost factor)
    */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
}
