package com.skillstorm.springmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.springmvc.dtos.UserDto;
import com.skillstorm.springmvc.models.User;
import com.skillstorm.springmvc.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



/*
 * Controller vs RestController
 *      @RestController implicitly adds @ResponseBody to every method in the class
 *              @ResponseBody will tell the controller that the object returned is serialized into JSON 
 *                            inside the body of the HTTP reponse
 *      @Controller you'd have to include it on every method 
 *          
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;

    /*
     * GET - retrieve data
     * POST - create data
     * PUT - updates data
     * DELETE - deletes data
     */

    // the actual path for the http request will be "/users/helloworld"
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World!";
    }

    /*
     * @GetMapping is an HTTP GET request
     *      same as @RequestMapping(method = RequestMethod.GET)
     */
    @GetMapping     //no path specified - will default to "/users"
    public List<UserDto> findAllUsers() {
        return service.findAllUsers();
    }

    /*
     * @RequestParam
     *      finds the data for the parameter in the url path
     * 
     *      "/users/first_name?firstName=[data]"" - everything after ? are your parameters
     */

    @GetMapping("/first_name")
    public List<User> findByFirstName(@RequestParam String firstName) {
        return service.findUsersByFirstName(firstName);
    }

    /*
     * @PathVariable
     *      finds data for the parameter in the url path
     * 
     *      "/users/user/[data]"
     */
    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id) {
        return service.findById(id);
    }
    
    /*
     * @PostMapping - typically used to create data
     * 
     * ResponseEntity - gives you more control over your http reponse
     *                  - modify headers, status code, etc.
     * 
     * @RequestBody - look for data in the body of the request 
     *                  - deserialize JSON to java object
     * 
     */
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createUser = service.createUser(user);
        return new ResponseEntity<User>(createUser, HttpStatus.CREATED);    //sets the status code to 201 - CREATED
    }

    /*
     * @PutMapping - used to update data
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = service.updateUser(id, user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);    //sets the status code to 200 - OK
    }

    /*
     * @DeleteMapping 
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id, @RequestBody User user) {
        service.deleteUser(id, user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);     //sets status code to 204 - NO_CONTENT
    }

}
