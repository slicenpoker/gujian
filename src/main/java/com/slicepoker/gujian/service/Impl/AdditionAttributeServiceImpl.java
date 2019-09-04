package com.slicepoker.gujian.service.Impl;

import com.slicepoker.gujian.pojo.AdditionAttribute;
import com.slicepoker.gujian.repository.AdditionAttributeRepository;
import com.slicepoker.gujian.service.AdditionAttributeService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionAttributeServiceImpl implements AdditionAttributeService {

    @Autowired
    private AdditionAttributeRepository additionAttributeRepository;

    @Override
    public Commes update(List<AdditionAttribute> additionAttributeList, String equipmentCode) {
        try {
            for (AdditionAttribute additionAttribute:additionAttributeList) {
                if (additionAttribute.getId()!=null){
                    additionAttribute.setEquipmentCode(equipmentCode);
                }
               additionAttributeRepository.save(additionAttribute);
            }
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","保存失败");
        }
    }


    @Override
    public Commes delete(String equipmentCode) {
        try {
            List<AdditionAttribute> additionAttributeList = additionAttributeRepository.findByEquipmentCodeAndDeletedIsFalse(equipmentCode);
            if (additionAttributeList.size()>0){
                for (AdditionAttribute additionAttribute:additionAttributeList){
                    additionAttribute.setDeleted(true);
                    additionAttributeRepository.save(additionAttribute);
                }
                return Commes.successMes();
            }else {
                return Commes.errorMes("401","无数据，请检查");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","删除失败");
        }
    }
}
