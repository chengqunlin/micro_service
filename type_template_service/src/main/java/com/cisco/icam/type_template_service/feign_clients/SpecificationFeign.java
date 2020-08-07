package com.cisco.icam.type_template_service.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("specification-service/specification")
public interface SpecificationFeign {

    @RequestMapping("/selectOptionList")
    List<Map<String, String>> selectOptionList();
}
