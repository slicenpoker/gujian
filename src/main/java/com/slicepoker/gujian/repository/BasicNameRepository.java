package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.AttributeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BasicNameRepository extends JpaRepository<AttributeName,Long>, JpaSpecificationExecutor<AttributeName> {
}
