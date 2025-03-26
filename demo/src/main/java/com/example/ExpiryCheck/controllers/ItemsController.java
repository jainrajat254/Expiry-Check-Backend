package com.example.ExpiryCheck.controllers;

import com.example.ExpiryCheck.data.Items;
import com.example.ExpiryCheck.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/items")
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add-items")
    public ResponseEntity<?> addItem(@RequestBody Items items) {
        try {
            Items addItem = itemService.addItem(items);
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong" + e.getMessage());
        }
    }

    @GetMapping("/get-items/{username}")
    public ResponseEntity<List<Items>> getItem(@PathVariable String username) {
        List<Items> itemsList = itemService.getItems(username);
        if (itemsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(itemsList);
    }
}
