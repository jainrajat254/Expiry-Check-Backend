package com.example.ExpiryCheck.service;

import com.example.ExpiryCheck.data.Items;
import com.example.ExpiryCheck.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public Items addItem(Items items) {
        return itemRepository.save(items);
    }

    public List<Items> getItems(String username) {
        return itemRepository.findByUser_Username(username); // Fetch user-specific items
    }
}
