package com.truth.security.services;

import com.truth.security.model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<Users> list = new ArrayList();

    public UserService(){
        list.add(new Users("abc", "abc", "abc@gmail.com"));
        list.add(new Users("xyz","xyz","xyz@gmail.com"));
    }

    //get all users
    public List<Users> getList(){
        return this.list;
    }

    //get single user
    public Users getUser(String username){
        return list.stream().filter((user)-> user.getUsername().equals(username)).findAny().orElse(null);
    }

    //add new user
    public Users addUser(Users user){
        list.add(user);
        return user;
    }

}
