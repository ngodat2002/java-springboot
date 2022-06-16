package com.example.relationshiphome.repository;

import com.example.relationshiphome.entity.Product;
import com.example.relationshiphome.entity.User;
import com.example.relationshiphome.entity.enums.ProductSimpleStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    //save product junit test
    @Test
    public void saveProduct(){
        Product product = new Product();
        product.setId("P01");
        product.setName("Nike Low Jordan");
        product.setDescription("Nike dep tuyet voi");
        product.setPrice(new BigDecimal(20));
        product.setSlug("nike-low-jordan");
        product.setStatus(ProductSimpleStatus.ACTIVE);
        productRepository.save(product);
        System.out.println(productRepository.findAll().size());
        Product product1 = productRepository.findAll().get(0);
        System.out.println(product1.toString());
    }
}