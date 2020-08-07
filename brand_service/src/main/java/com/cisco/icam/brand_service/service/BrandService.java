package com.cisco.icam.brand_service.service;

import com.cisco.icam.brand_service.repository.BrandRepository;
import com.cisco.icam.brand_service.entity.PageResult;
import com.cisco.icam.brand_service.entity.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"id");
        return brandRepository.findAll(sort);
    }

    public List<Map<String, String>> selectOptionList() {
        return brandRepository.selectOptionList();
    }

    public void delete(Long[] ids) {
        List<Brand> brands = new ArrayList<>();
        Arrays.stream(ids).forEach(id->{
            Brand brand = new Brand();
            brand.setId(id);
            brands.add(brand);
        });
        brandRepository.deleteInBatch(brands);
    }

    public PageResult findPage(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Brand> page = brandRepository.findAll(pageable);
        return new PageResult(page.getContent(),page.getSize());
    }

    public PageResult search(Integer pageNum, Integer pageSize, Brand brand) {
        String firstChar = brand.getFirstChar().trim();
        String name = brand.getName().trim();
        Brand example = new Brand();
        if(StringUtils.isNotBlank(name)){
            example.setName(name);
        }
        if(StringUtils.isNotBlank(firstChar)){
            example.setFirstChar(firstChar);
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("firstChar", ExampleMatcher.GenericPropertyMatcher::contains)//模糊查询
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains)
                .withIgnorePaths("id");
        Example<Brand> brandExample = Example.of(example,matcher);
        Page<Brand> brands= brandRepository.findAll(brandExample,PageRequest.of(pageNum,pageSize));
        return new PageResult(brands.getContent(),brands.getSize());
    }

    public void add(Brand brand) {
        brandRepository.save(brand);
    }

    public Brand findOne(Long id) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        return brandOptional.orElse(null);
    }

    public void update(Brand brand) {
        brandRepository.saveAndFlush(brand);
    }
}
