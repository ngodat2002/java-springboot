package com.maiyeuem.productclothes.repository;

import com.maiyeuem.productclothes.entity.Product;
import com.maiyeuem.productclothes.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
