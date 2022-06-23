package com.order.relationship.repository;

import com.order.relationship.RelationshipApplication;
import com.order.relationship.entity.Product;
import com.order.relationship.entity.enums.ProductSimpleStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RelationshipApplication.class})
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void testSaveProduct(){
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name("Nike")
                .detail("Dep qua")
                .thumbnails("nike.png")
                .status(ProductSimpleStatus.ACTIVE)
                .price(new BigDecimal(20))
                .build();
        productRepository.save(product);
        System.out.println(productRepository.findAll().size());
        Product product1 = productRepository.findAll().get(0);
        System.out.println(product1.toString());
    }
}