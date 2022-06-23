package com.order.relationship.repository;

import com.order.relationship.entity.Product;
import com.order.relationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
