package com.cisco.icam.type_template_service.repository;

import com.cisco.icam.type_template_service.entity.TypeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTemplateRepository extends JpaRepository<TypeTemplate,Long> {
}
