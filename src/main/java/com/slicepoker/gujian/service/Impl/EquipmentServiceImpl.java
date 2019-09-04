package com.slicepoker.gujian.service.Impl;

import com.slicepoker.gujian.pojo.Equipment;
import com.slicepoker.gujian.repository.AdditionAttributeRepository;
import com.slicepoker.gujian.repository.BasicAttributeRepository;
import com.slicepoker.gujian.repository.EquipmentRepository;
import com.slicepoker.gujian.service.AdditionAttributeService;
import com.slicepoker.gujian.service.BasicAttributeService;
import com.slicepoker.gujian.service.EquipmentService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private AdditionAttributeService additionAttributeService;

    @Autowired
    private BasicAttributeService basicAttributeService;

    @Autowired
    private AdditionAttributeRepository additionAttributeRepository;

    @Autowired
    private BasicAttributeRepository basicAttributeRepository;


    @Override
    public Commes update(Equipment equipment) {
        try {
            if (equipment.getId()!=null){
                equipment.setEquipmentCode(UUID.randomUUID().toString());
                equipment.setCreateDate(new Date());
            }else {
                equipment.setModifyDate(new Date());
            }
            additionAttributeService.update(equipment.getAttributeArrayList(),equipment.getEquipmentCode());
            basicAttributeService.update(equipment.getBasicAttributeList(),equipment.getEquipmentCode());
            equipmentRepository.save(equipment);
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","修改失败");
        }
    }


    @Override
    public Commes delete(Long id) {
        try {
            Equipment equipment = equipmentRepository.findByIdAndDeletedIsFalse(id);
            if (equipment!=null){
                additionAttributeService.delete(equipment.getEquipmentCode());
                basicAttributeService.delete(equipment.getEquipmentCode());
                equipment.setDeleted(true);
                equipmentRepository.save(equipment);
                return Commes.successMes();
            }else {
                return Commes.errorMes("401","未找到该条数据，请检查");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","删除失败");
        }
    }


    @Override
    public Commes findById(Long id) {
        try {
            Equipment equipment = equipmentRepository.findByIdAndDeletedIsFalse(id);
            if (equipment!=null){
                equipment.setAttributeArrayList(additionAttributeRepository.findByEquipmentCodeAndDeletedIsFalse(equipment.getEquipmentCode()));
                equipment.setBasicAttributeList(basicAttributeRepository.findByEquipmentCodeAndDeletedIsFalse(equipment.getEquipmentCode()));
            }
            return Commes.success(equipment);
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","未找到该条数据，请检查");
        }
    }
}
