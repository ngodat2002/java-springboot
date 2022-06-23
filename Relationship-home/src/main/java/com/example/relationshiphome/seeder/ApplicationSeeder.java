package com.example.relationshiphome.seeder;

import com.example.relationshiphome.entity.Order;
import com.example.relationshiphome.entity.OrderDetail;
import com.example.relationshiphome.entity.OrderDetailId;
import com.example.relationshiphome.entity.Product;
import com.example.relationshiphome.entity.enums.OrderSimpleStatus;
import com.example.relationshiphome.entity.enums.ProductSimpleStatus;
import com.example.relationshiphome.repository.OrderRepository;
import com.example.relationshiphome.repository.ProductRepository;
import com.example.relationshiphome.util.StringHelper;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
public class ApplicationSeeder implements CommandLineRunner {

    boolean createSeedData = false;
    final OrderRepository orderRepository;
    final ProductRepository productRepository;
    Faker faker;
    int numberOfProduct = 100;
    int numberOfOrder = 1000;

    public ApplicationSeeder(
            OrderRepository orderRepository,
            ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if(createSeedData){
            orderRepository.deleteAll();
            productRepository.deleteAll();
            seedProduct();
            seedOrder();
        }
    }

    private void seedOrder() {
        List<Product> products = productRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < numberOfOrder; i++) {
            Order order = new Order();
            order.setUserId("1");
            order.setId(UUID.randomUUID().toString());
            Set<OrderDetail> orderDetails = new HashSet<>();
            int randomOrderDetailNumber = faker.number().numberBetween(1, 5);
            HashSet<String> existingProductId = new HashSet<>();
            for (int j = 0; j < randomOrderDetailNumber; j++) {
                OrderDetail orderDetail = new OrderDetail();
                Product randomProduct = products.get(
                        faker.number().numberBetween(0, products.size() - 1));
                if (existingProductId.contains(randomProduct.getId())) {
                    continue;
                }
                existingProductId.add(randomProduct.getId());
                orderDetail.setId(new OrderDetailId(order.getId(), randomProduct.getId()));
                orderDetail.setOrder(order);
                orderDetail.setProduct(randomProduct);
                orderDetail.setUnitPrice(randomProduct.getPrice());
                orderDetail.setQuantity(faker.number().numberBetween(1, 5));
                order.addTotalPrice(orderDetail);
                orderDetails.add(orderDetail);
            }
            order.setOrderDetails(orderDetails);
            order.setStatus(OrderSimpleStatus.DONE);
            orders.add(order);
        }
        orderRepository.saveAll(orders);
    }

    private void seedProduct() {
        List<Product> listProduct = new ArrayList<>();
        for (int i = 0; i < numberOfProduct; i++) {
            System.out.println(i + 1);
            Product product = new Product();
            product.setId(UUID.randomUUID().toString());
            product.setName(faker.name().title());
            product.setSlug(StringHelper.toSlug(product.getName()));
            product.setDescription(faker.lorem().sentence());
            product.setPrice(
                    new BigDecimal(faker.number().numberBetween(100, 200) * 10000));
            product.setCreatedBy("0");
            product.setUpdatedBy("0");
            product.setDetail(faker.lorem().sentence());
            product.setThumbNails(faker.avatar().image());
            product.setStatus(ProductSimpleStatus.ACTIVE);
            listProduct.add(product);
            System.out.println(product.toString());
        }
        productRepository.saveAll(listProduct);
    }

    public static void main(String[] args) {

    }
}