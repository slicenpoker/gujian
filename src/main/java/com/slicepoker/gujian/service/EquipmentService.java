package com.slicepoker.gujian.service;

import com.slicepoker.gujian.pojo.Equipment;
import com.slicepoker.gujian.utils.Commes;

public interface EquipmentService {

    Commes update(Equipment equipment);

    Commes delete(Long id);

    Commes findById(Long id);
}
