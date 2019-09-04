package com.slicepoker.gujian.service.Impl;

import com.slicepoker.gujian.pojo.GameType;
import com.slicepoker.gujian.repository.GameTypeRepository;
import com.slicepoker.gujian.service.GameTypeService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameTypeServiceImpl implements GameTypeService {

    @Autowired
    private GameTypeRepository gameTypeRepository;

    @Override
    public Commes update(GameType gameType) {
        try {
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.badRequestError();
        }
    }


    @Override
    public Commes delete(Long id) {
        try {
            GameType gameType = gameTypeRepository.findByIdAndDeletedIsFalse(id);
            if (gameType!=null){
                gameType.setDeleted(true);
                gameTypeRepository.save(gameType);
                return Commes.successMes();
            }else {
                return Commes.errorMes("401","未找到该条数据请检查");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","删除失败");
        }
    }
}
