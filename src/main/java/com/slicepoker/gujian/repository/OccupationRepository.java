package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Slicen
 * @date 2019/8/16 16:22
 * @description
 */
public interface OccupationRepository extends JpaRepository<Occupation,Long>, JpaSpecificationExecutor<Occupation> {
}
