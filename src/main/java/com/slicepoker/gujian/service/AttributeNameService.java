package com.slicepoker.gujian.service;

import com.slicepoker.gujian.pojo.AttributeName;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.data.domain.Pageable;

public interface AttributeNameService {

    Commes update(AttributeName attributeName);

    Commes delete(Long id);

    Commes getAttributeName();

    Commes getData(Pageable pageable,String typeCode);
}
