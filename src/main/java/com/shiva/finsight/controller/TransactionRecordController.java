package com.shiva.finsight.controller;

import com.shiva.finsight.entity.Category;
import com.shiva.finsight.entity.TransactionRecord;
import com.shiva.finsight.entity.User;
import com.shiva.finsight.repository.CategoryRepository;
import com.shiva.finsight.repository.TransactionRecordRepository;
import com.shiva.finsight.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionRecordController {

    private TransactionRecordRepository transactionRecordRepository;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public TransactionRecord createTransaction(@PathVariable Long userId,
                                               @PathVariable Long categoryId,
                                               @RequestBody TransactionRecord transactionRecord) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND WITH ID: " + userId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("CATEGORY NOT FOUND WITH ID: " + categoryId));

        transactionRecord.setUser(user);
        transactionRecord.setCategory(category);

        return transactionRecordRepository.save(transactionRecord);
    }

    @GetMapping
    public List<TransactionRecord> getAllTransactions() {
        return transactionRecordRepository.findAll();
    }
}