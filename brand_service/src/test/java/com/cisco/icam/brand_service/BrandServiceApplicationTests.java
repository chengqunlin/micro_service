package com.cisco.icam.brand_service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
class BrandServiceApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(dataSource);
    }

}
