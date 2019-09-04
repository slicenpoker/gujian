package com.slicepoker.gujian.service;

import com.slicepoker.gujian.pojo.AdditionAttribute;
import com.slicepoker.gujian.utils.Commes;

import java.util.List;

public interface AdditionAttributeService {

    Commes update(List<AdditionAttribute> additionAttributeList,String equipmentCode);

    Commes delete(String equipmentCode);


}
