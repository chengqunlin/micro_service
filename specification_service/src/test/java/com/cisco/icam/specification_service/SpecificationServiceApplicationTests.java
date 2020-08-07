package com.cisco.icam.specification_service;

import com.cisco.icam.specification_service.entity.Specification;
import com.cisco.icam.specification_service.entity.SpecificationOption;
import com.cisco.icam.specification_service.respository.SpecificationOptionRepository;
import com.cisco.icam.specification_service.respository.SpecificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpecificationServiceApplicationTests {

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private SpecificationOptionRepository specificationOptionRepository;
    @Test
    void contextLoads() {

    }

    @Test
    public void test(){
        List<Specification> all = specificationRepository.findAll();
        System.out.println(all);
    }
    @Test
    public void test2(){
        Optional<SpecificationOption> byId = specificationOptionRepository.findById(91L);
        List<SpecificationOption> all = specificationOptionRepository.findAll();
        System.out.println(all);
    }

}
