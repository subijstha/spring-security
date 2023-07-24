package com.truth.security.controllers;

import com.truth.security.model.Users;
import com.truth.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;




    //all users
    @GetMapping()
    public List<Users> getAllUsers(){
        return this.userService.getList();
    }


    @GetMapping("/{username}")
    public Users getUser(@PathVariable String username){
        return this.userService.getUser(username);
    }

    @PostMapping()
    public Users addUser(@RequestBody Users user){
        return this.userService.addUser(user);
    }
}
