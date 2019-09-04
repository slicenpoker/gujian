package com.slicepoker.gujian.service;

import com.slicepoker.gujian.pojo.GameType;
import com.slicepoker.gujian.utils.Commes;

public interface GameTypeService {

    Commes update(GameType gameType);

    Commes delete(Long id);
}
