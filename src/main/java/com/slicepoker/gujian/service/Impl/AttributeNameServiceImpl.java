package com.slicepoker.gujian.service.Impl;

import com.slicepoker.gujian.pojo.AttributeName;
import com.slicepoker.gujian.repository.AttributeNameRepository;
import com.slicepoker.gujian.service.AttributeNameService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AttributeNameServiceImpl implements AttributeNameService {

    @Autowired
    private AttributeNameRepository attributeNameRepository;

    @Override
    public Commes update(AttributeName attributeName) {
        try {
            if (attributeName.getId()!=null){
                attributeName.setAttributeCode(UUID.randomUUID().toString());
                attributeName.setCreateDate(new Date());
            }else {
                attributeName.setModifyDate(new Date());
            }
            attributeNameRepository.save(attributeName);
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("401","修改属性失败");
        }
    }


    @Override
    public Commes delete(Long id) {
        try {
            AttributeName attributeName = attributeNameRepository.findByIdAndDeletedIsFalse(id);
            if (attributeName!=null){
                attributeName.setDeleted(true);
                attributeNameRepository.save(attributeName);
                return Commes.successMes();
            }else {
                return Commes.errorMes("401","未找到该条数据，删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Commes.badRequestError();
        }
    }


    @Override
    public Commes getAttributeName() {
        try {
            return Commes.successMes();
        }catch (Exception e){
            e.printStackTrace();
            return Commes.errorMes("405","获取数据失败");
        }
    }


    @Override
    public Commes getData(Pageable pageable,String typeCode) {
        try {
            Page<AttributeName> page = attributeNameRepository.findAll(((root, query, cb) -> {
                List<Predicate> list = new ArrayList<>();
                list.add(
                        cb.and(
                                cb.equal(root.get("deleted"),false),
                                cb.equal(root.get("typeCode"),typeCode)
                        ));

                return cb.and(list.toArray(new Predicate[list.size()]));
            }),pageable);
            return Commes.success(page);
        }catch (Exception e){
            e.printStackTrace();
            return Commes.badRequestError();
        }
    }
}
