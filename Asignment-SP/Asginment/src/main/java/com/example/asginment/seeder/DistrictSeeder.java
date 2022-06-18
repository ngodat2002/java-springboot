package com.example.asginment.seeder;

import com.example.asginment.entity.District;
import com.example.asginment.repository.DistrictRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class DistrictSeeder {
    private static final int NUMBER_DISTRICT = 5;
    public static List<District> districts;
    @Autowired
    DistrictRepository districtRepository;
    public void generate(){
        log.debug("=============START SEEDING DISTRICT============");
        Faker faker = new Faker();
        districts = new ArrayList<>();
        for (int i = 0; i < NUMBER_DISTRICT; i++) {
            districtRepository.save(District.builder()
                    .id(UUID.randomUUID().toString())
                    .name(faker.address().country())
                    .build());
        }
        log.debug("=============END OF SEEDING PRODUCT============");
    }
}
