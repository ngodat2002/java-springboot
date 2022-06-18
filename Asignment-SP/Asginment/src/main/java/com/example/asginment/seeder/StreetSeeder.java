package com.example.asginment.seeder;

import com.example.asginment.entity.District;
import com.example.asginment.entity.Street;
import com.example.asginment.entity.enums.StreetSimpleStatus;
import com.example.asginment.repository.DistrictRepository;
import com.example.asginment.repository.StreetRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

@Component
@Slf4j
public class StreetSeeder {
    private static final int NUMBER_DISTRICT_MIN = 1;
    private static final int NUMBER_DISTRICT_MAX = 5;
    private static final int NUMBER_STREET = 10;

    public static List<Street> streets;
    @Autowired
    StreetRepository streetRepository;
    public void generate(){
        log.debug("=============START SEEDING Street============");
        Faker faker = new Faker();
        streets = new ArrayList<>();
        for (int i = 0; i < NUMBER_STREET; i++) {
            Street street = new Street();
            street.setId(UUID.randomUUID().toString());
            street.setDescription(faker.leagueOfLegends().rank());
            street.setStatus(StreetSimpleStatus.USING);
        }
        streetRepository.saveAll(streets);
        log.debug("=============END OF SEEDING Street============");
    }
}
