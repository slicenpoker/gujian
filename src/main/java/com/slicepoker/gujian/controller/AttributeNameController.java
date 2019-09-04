package com.slicepoker.gujian.controller;

import com.slicepoker.gujian.pojo.AttributeName;
import com.slicepoker.gujian.service.AttributeNameService;
import com.slicepoker.gujian.utils.Commes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attribute")
public class AttributeNameController {

    @Autowired
    private AttributeNameService attributeNameService;

    @PostMapping("/")
    public Commes update(@RequestBody AttributeName attributeName){
        return attributeNameService.update(attributeName);
    }

    @DeleteMapping("/{id}")
    public Commes delete(@PathVariable Long id){
        return attributeNameService.delete(id);
    }
}
