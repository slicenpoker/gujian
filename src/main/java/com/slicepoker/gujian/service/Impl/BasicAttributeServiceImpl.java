package com.slicepoker.gujian.service.Impl;

import com.slicepoker.gujian.pojo.BasicAttribute;
import com.slicepoker.gujian.repository.BasicAttributeRepository;
import com.slicepoker.gujian.service.BasicAttributeService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicAttributeServiceImpl implements BasicAttributeService {

    @Autowired
    private BasicAttributeRepository basicAttributeRepository;

    @Override
    public Commes update(List<BasicAttribute> basicAttributeList, String equipmentCode) {
        try {
            for (BasicAttribute basicAttribute:basicAttributeList) {
                if (basicAttribute.getId()!=null){
                    basicAttribute.setEquipmentCode(equipmentCode);
                }
                basicAttributeRepository.save(basicAttribute);
            }
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","新增失败");
        }
    }


    @Override
    public Commes delete(String equipmentCode) {
        try {
            List<BasicAttribute> basicAttributeList = basicAttributeRepository.findByEquipmentCodeAndDeletedIsFalse(equipmentCode);
            if (basicAttributeList.size()>0){
                for (BasicAttribute basicAttribute:basicAttributeList){
                    basicAttribute.setDeleted(true);
                    basicAttributeRepository.save(basicAttribute);
                }
                return Commes.successMes();
            }else {
                return Commes.errorMes("401","无数据");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","查询失败");
        }
    }
}
