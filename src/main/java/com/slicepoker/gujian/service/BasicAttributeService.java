package com.slicepoker.gujian.service;

import com.slicepoker.gujian.pojo.BasicAttribute;
import com.slicepoker.gujian.utils.Commes;

import java.util.List;

public interface BasicAttributeService {

    Commes update(List<BasicAttribute> basicAttributeList,String equipmentCode);

    Commes delete(String equipmentCode);
}
