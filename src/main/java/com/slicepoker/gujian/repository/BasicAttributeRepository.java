package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.BasicAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.validation.constraints.Max;
import java.util.List;

public interface BasicAttributeRepository extends JpaRepository<BasicAttribute,Long>, JpaSpecificationExecutor<BasicAttribute> {

    List<BasicAttribute> findByEquipmentCodeAndDeletedIsFalse(String equipmentCode);
}
