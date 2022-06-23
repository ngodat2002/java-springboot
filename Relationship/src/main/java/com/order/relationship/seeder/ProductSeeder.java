package com.order.relationship.seeder;

import com.order.relationship.entity.Product;
import com.order.relationship.entity.enums.ProductSimpleStatus;
import com.order.relationship.repository.ProductRepository;
import com.order.relationship.util.NumberUtil;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class ProductSeeder {

    public static List<Product> products;
    public static final int NUMBER_OF_PRODUCT = 50;

    @Autowired
    ProductRepository productRepository;

    public void generate() {
        log.debug("------------Seeding product-------------");
        Faker faker = new Faker();
        products = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_PRODUCT; i++) {
            products.add(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name(faker.name().name())
                    .price(new BigDecimal(NumberUtil.getRandomNumber(100, 1000) * 1000))
                    .thumbnails(faker.avatar().image())
                    .detail(faker.lorem().sentence())
                    .status(ProductSimpleStatus.ACTIVE)
                    .build());
        }
        productRepository.saveAll(products);
        log.debug("--------------End of seeding product-------------");
    }
}
