package com.pralashgroup.restfulwebservicespart1.withOutJPA.socialmedia;

import com.pralashgroup.restfulwebservicespart1.withOutJPA.socialmedia.exception.UserNotFound;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user=service.findById(id);
        if (user==null){
            throw  new UserNotFound("User with "+id+ " is not available !!");
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable Integer id){
        User user = service.findById(id);
        if (user==null){
            throw  new UserNotFound("User with "+id+ " is not available !!");
        }
        service.deleteById(id);
    }
    @PostMapping("/add-user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return new ResponseEntity<>(service.saveUser(user),HttpStatus.CREATED);
    }

}
