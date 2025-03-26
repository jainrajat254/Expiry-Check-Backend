package com.example.ExpiryCheck.repository;

import com.example.ExpiryCheck.data.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Items,String> {

    List<Items> findByUser_Username(String username);
}
