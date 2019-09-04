package com.slicepoker.gujian.repository;

import com.slicepoker.gujian.pojo.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GameTypeRepository extends JpaRepository<GameType,Long>, JpaSpecificationExecutor<GameType> {

    GameType findByIdAndDeletedIsFalse(Long id);

    GameType findByGameNameAndDeletedIsFalse(String gameName);
}
