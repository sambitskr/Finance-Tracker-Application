package com.example.FinanceTracker.Service;

import com.example.FinanceTracker.Model.User;
import com.example.FinanceTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;


    public void createNewUser(User user) {
        userRepo.save(user);
    }

    public List<User> showAllUsers() {
       return userRepo.findAll();
    }

    public User getUserByID(long id){
        return userRepo.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    public void updateUser(long id, User user) {
         userRepo.save(user);
    }
}
