package com.cisco.icam.type_template_service.controller;


import com.cisco.icam.type_template_service.entity.TypeTemplate;
import com.cisco.icam.type_template_service.feign_clients.BrandFeignClient;
import com.cisco.icam.type_template_service.feign_clients.SpecificationFeign;
import com.cisco.icam.type_template_service.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TypeTemplateController {

    @Autowired
    private TypeTemplateService typeTemplateService;

    @Autowired
    private BrandFeignClient brandFeignClient;

    @Autowired
    private SpecificationFeign specificationFeign;
    @PostMapping("/search")
    public List<TypeTemplate> search(Integer page, Integer rows, @RequestBody TypeTemplate typeTemplate){
        return typeTemplateService.search(page, rows, typeTemplate);
    }

    @PostMapping("/add")
    public void add(@RequestBody TypeTemplate typeTemplate){
         typeTemplateService.add(typeTemplate);
    }

    @GetMapping("/findOne")
    public TypeTemplate findOne(long id){
        return typeTemplateService.findOne(id);
    }
    @PostMapping("/update")
    public void update(@RequestBody TypeTemplate typeTemplate){
         typeTemplateService.update(typeTemplate);
    }

    @GetMapping("/delete")
    public void delete(long[] ids){
        typeTemplateService.delete(ids);
    }

    @GetMapping("/listBrands")
    public List<Map<String, String>> listBrands(){
        return brandFeignClient.selectBrandOptionList();
    }

    @GetMapping("/listSpecification")
    public List<Map<String, String>> listSpecification(){
        return specificationFeign.selectOptionList();
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
