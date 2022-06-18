package com.example.asginment.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;
//sinh ra du lieu 5 nam
@Component
public class ApplicationSeeder  implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(ApplicationSeeder.class.getSimpleName());
    @Autowired
    DistrictSeeder districtSeeder;
    @Autowired
    StreetSeeder streetSeeder;

    @Override
    public void run(String... args) throws Exception{
        logger.log(Level.SEVERE,"Start seeder");
        districtSeeder.generate();
        streetSeeder.generate();
    }
}
