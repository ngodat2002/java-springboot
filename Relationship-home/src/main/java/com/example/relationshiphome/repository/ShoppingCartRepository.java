package com.example.relationshiphome.repository;

import com.example.relationshiphome.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,String> {
}
