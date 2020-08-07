package com.cisco.icam.specification_service.respository;

import com.cisco.icam.specification_service.entity.SpecificationOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface SpecificationOptionRepository extends JpaRepository<SpecificationOption, Long> {

    @Transactional  //update/delete query要加 @Transactional 注解
    @Modifying  //@Query 只适用于查询，要增改删要加 @Modifying
    @Query(value = "delete from tb_specification_option where spec_id=?1",nativeQuery = true)
    void deleteBySpecId(long specId);

    //第二种传参的方式
    /*
        @Query(value = "select * from t_user where t_age > :age", nativeQuery = true)
        List<UserEntity> listAgeMoreThan(@Param("age") Integer age);
     */
}
