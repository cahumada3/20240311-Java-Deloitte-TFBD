package com.skillstorm.springmvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.springmvc.dtos.UserDto;
import com.skillstorm.springmvc.mappers.UserMapper;
import com.skillstorm.springmvc.models.User;

@Service // this is where all your business logic will be
public class UserService {

    @Autowired
    UserMapper mapper;
    
    public List<UserDto> findAllUsers() {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skilstorm.com", "123password!"));
        users.add(new User(1, "Dexter", "Tournesy", "dtournesy@skilstorm.com", "123password!"));
        users.add(new User(2, "Caleb", "Butler", "cbutler@skilstorm.com", "123password!"));
        users.add(new User(3, "Waleed", "Qureshi", "wqureshi@skilstorm.com", "123password!"));

        //converting List<user> to Stream<User>
        //then converting Stream<User> to Stream<UserDto>
        //then converting Stream<UserDto> to List<UserDto>
        List<UserDto> userDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());
        return userDtos;
    }

    public List<User> findUsersByFirstName(String name) {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skilstorm.com", "123password!"));
        users.add(new User(1, "Dexter", "Tournesy", "dtournesy@skilstorm.com", "123password!"));
        users.add(new User(2, "Caleb", "Butler", "cbutler@skilstorm.com", "123password!"));
        users.add(new User(3, "Waleed", "Qureshi", "wqureshi@skilstorm.com", "123password!"));

        return users;
    }

    public User findById(long id) {
        return new User(id, "Robert", "Padilla", "rpadilla@skillstorm.com", "123password!");
    }

    public User createUser(User user) {
        user.setId(10000);
        return user;
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return user;
    }

    public User deleteUser(long id, User user) {
        return user;
    }
    
}
