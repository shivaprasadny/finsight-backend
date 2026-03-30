package com.shiva.finsight.controller;

import com.shiva.finsight.entity.User;
import com.shiva.finsight.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private UserRepository userRepository;

    // To create User rest Api
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
@GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
