package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.AdditionAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdditionAttributeRepository extends JpaRepository<AdditionAttribute,Long>, JpaSpecificationExecutor<AdditionAttribute> {

    List<AdditionAttribute> findByEquipmentCodeAndDeletedIsFalse(String equipmentCode);
}
