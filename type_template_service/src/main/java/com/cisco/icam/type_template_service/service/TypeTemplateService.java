package com.cisco.icam.type_template_service.service;

import com.cisco.icam.type_template_service.entity.TypeTemplate;
import com.cisco.icam.type_template_service.repository.TypeTemplateRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeTemplateService {

    @Autowired
    private TypeTemplateRepository typeTemplateRepository;
    public List<TypeTemplate> search(Integer pageNum, Integer pageSize, TypeTemplate typeTemplate) {
        String name = typeTemplate.getName();
        TypeTemplate example = new TypeTemplate();
        if (StringUtils.isNotBlank(name)){
            example.setName(name.trim());
        }
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::contains)
                .withIgnorePaths("specIds")
                .withIgnorePaths("brandIds")
                .withIgnorePaths("customAttributeItems")
                .withIgnorePaths("id");
        Example<TypeTemplate> brandExample = Example.of(example,matcher);
        Page<TypeTemplate> typeTemplates= typeTemplateRepository.findAll(brandExample,PageRequest.of(pageNum,pageSize));
        return typeTemplates.getContent();
    }
    @Transactional
    public void add(TypeTemplate typeTemplate) {
        typeTemplateRepository.save(typeTemplate);
    }

    public TypeTemplate findOne(long id) {
        return typeTemplateRepository.findById(id).orElseGet(null);
    }

    public void delete(long[] ids) {
        ArrayList<TypeTemplate> typeTemplates = new ArrayList<>();
        for (long id : ids) {
            typeTemplates.add(new TypeTemplate(id));
        }
        typeTemplateRepository.deleteAll(typeTemplates);
    }


    public void update(TypeTemplate typeTemplate) {
        typeTemplateRepository.save(typeTemplate);
    }
}
