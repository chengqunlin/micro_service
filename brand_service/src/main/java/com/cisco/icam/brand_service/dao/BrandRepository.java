package com.cisco.icam.brand_service.dao;

import com.cisco.icam.brand_service.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "select id, name text from tb_brand", nativeQuery = true)
    List<Map<String, String>> selectOptionList();
}
