package com.example.FinanceTracker.Controllers;

import com.example.FinanceTracker.Model.User;
import com.example.FinanceTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void createNewUser(@RequestBody User user){
        userService.createNewUser(user);

    }

    @GetMapping("/user")
    public ResponseEntity<List<User>>showAllUsers(){
        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){

        User user = userService.getUserByID(id);

        if(user != null){
            userService.deleteUser(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody User user){
        User user1 =null;

        try{
            user1 = userService.getUserByID(id);

        }catch(Exception e){
            return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
        }

        if(user1 != null) {
            userService.updateUser(id, user);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
    }

 }
//{
//        "id": 1,
//        "total": "14000",
//        "name": "sambit sarkar",
//        "email": "sambit@gmail.com",
//        "password": "qwerty"
//        }