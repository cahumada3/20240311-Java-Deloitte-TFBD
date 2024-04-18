package com.skillstorm.springsecurity.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skillstorm.springsecurity.models.AppUser;
import com.skillstorm.springsecurity.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * search through the db for a user with username, or throw an exception if it can't find it
     * 
     * Spring Security will use this method to find users
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        return user;
    }

    public void register(AppUser user) {

        // first we need to check if the username is taken
        Optional<AppUser> foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser.isPresent()) {
            
            // [insert some logic to tell fronted that the username already exists]

            throw new RuntimeException("User with that username already exists.");
        }

        /**
         * next we need to ENCODE the user's password
         *      spring security is expecting you to use BCrypt
         *          - otherwise error: "Password doesn't look like BCrypt"
         */
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // setting the incoming user to the default level of access
        user.setRole("ROLE_USER");

        // finally save to db
        userRepository.save(user);
    }

    public void registerAdmin(AppUser user) {

        // first we need to check if the username is taken
        Optional<AppUser> foundUser = userRepository.findByUsername(user.getUsername());
        if(foundUser.isPresent()) {
            
            // [insert some logic to tell fronted that the username already exists]

            throw new RuntimeException("User with that username already exists.");
        }

        /**
         * next we need to ENCODE the user's password
         *      spring security is expecting you to use BCrypt
         *          - otherwise error: "Password doesn't look like BCrypt"
         */
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // setting the incoming user to the default level of access
        user.setRole("ROLE_USER");

        // finally save to db
        userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")     // security advice - works like @Before 
    public long countAllUsers() {
        return userRepository.count();
    }

}
