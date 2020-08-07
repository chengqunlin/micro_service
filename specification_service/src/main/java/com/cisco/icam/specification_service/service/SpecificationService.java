package com.cisco.icam.specification_service.service;

import com.cisco.icam.specification_service.entity.PageResult;
import com.cisco.icam.specification_service.entity.Specification;
import com.cisco.icam.specification_service.entity.SpecificationOption;
import com.cisco.icam.specification_service.entity.SpecificationVo;
import com.cisco.icam.specification_service.respository.SpecificationOptionRepository;
import com.cisco.icam.specification_service.respository.SpecificationRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SpecificationService {

    @Autowired
    private SpecificationRepository specificationRepository;
    @Autowired
    private SpecificationOptionRepository specificationOptionRepository;

    public PageResult search(Integer page, Integer rows, Specification specification) {
        String specName = specification.getSpecName().trim();
        Specification example = new Specification();
        if (StringUtils.isNotBlank(specName)){
            example.setSpecName(specName);
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("specName", ExampleMatcher.GenericPropertyMatcher::contains)//模糊查询
                .withIgnorePaths("id");
        Example<Specification> specificationExample = Example.of(example, matcher);
        Page<Specification> pages = specificationRepository.findAll(specificationExample, PageRequest.of(page, rows));
        return new PageResult(pages.getContent(),pages.getSize());
    }

    //TODO 接口幂等性用redis来做
    public void add(SpecificationVo specificationVo) {
        Specification specification = specificationVo.getSpecification();
        Specification save = specificationRepository.save(specification);

        List<SpecificationOption> specificationOptionList = specificationVo.getSpecificationOptionList();
        if (specificationOptionList!=null&&specificationOptionList.size()>0){
            specificationOptionList.forEach(specificationOption -> specificationOption.setSpecId(save.getId()));
            specificationOptionRepository.saveAll(specificationOptionList);
        }
    }

    public SpecificationVo findOne(Long id) {
        Optional<Specification> specificationOptional = specificationRepository.findById(id);
        SpecificationVo specificationVo = null;
        if (specificationOptional.isPresent()){
            specificationVo = new SpecificationVo();
            Specification specification = specificationOptional.get();
            specificationVo.setSpecification(specification);

            SpecificationOption specificationOption = new SpecificationOption();
            specificationOption.setSpecId(specification.getId());
            ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("id", "orders");
            Example<SpecificationOption> example = Example.of(specificationOption,matcher);
            List<SpecificationOption> specificationOptionList = specificationOptionRepository.findAll(example);
            specificationVo.setSpecificationOptionList(specificationOptionList);
        }
        return specificationVo;
    }

    public void update(SpecificationVo specificationVo) {
        Specification specification = specificationVo.getSpecification();
        List<SpecificationOption> specificationOptionList = specificationVo.getSpecificationOptionList();
        specificationRepository.save(specification);
        long specId = specification.getId();
        specificationOptionRepository.deleteBySpecId(specId);
        specificationOptionList.forEach(specificationOption -> specificationOption.setSpecId(specId));
        specificationOptionRepository.saveAll(specificationOptionList);
    }

    public void delete(Long[] ids) {
        List<Specification> specifications = new ArrayList<>();
        Arrays.stream(ids).forEach(id->specifications.add(new Specification(id)));
        specificationRepository.deleteInBatch(specifications);

        for (Long id : ids) {
            specificationOptionRepository.deleteBySpecId(id);
        }
    }

    public List<Map<String, String>> selectOptionList() {
        return specificationRepository.seletOptionList();
    }
}
