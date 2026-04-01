package com.shiva.finsight.controller;


import com.shiva.finsight.entity.Category;
import com.shiva.finsight.entity.User;
import com.shiva.finsight.repository.CategoryRepository;
import com.shiva.finsight.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private UserRepository userRepository;
    private CategoryRepository categoryRepository;


    @PostMapping("/user/{userId}")
    public Category createCategory(@PathVariable Long userId ,@RequestBody Category category){
        User user = userRepository.findById(userId).orElseThrow(()-> new RuntimeException("USER NOT FOUND WITH ID : " + userId));

        category.setUser(user);
        return categoryRepository.save(category);
    }
     @GetMapping
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
}
