package com.cisco.icam.specification_service.respository;

import com.cisco.icam.specification_service.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Long> {
    @Query(value = "select id, spec_name text from tb_specification",nativeQuery = true)
    List<Map<String, String>> seletOptionList();
}
