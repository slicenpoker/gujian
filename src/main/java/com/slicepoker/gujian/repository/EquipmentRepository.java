package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EquipmentRepository extends JpaRepository<Equipment,Long>, JpaSpecificationExecutor<Equipment> {

    Equipment findByIdAndDeletedIsFalse(Long id);
}
