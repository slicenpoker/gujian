package com.slicepoker.gujian.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Slicen
 * @date 2019/8/16 16:23
 * @description 装备
 */
@Data
@Entity
@Table(name = "tb_equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String equipmentName;  //名称

    private String OccupationCode; //职业

    private String equipmentCode;  //code

    private String type;  //类型

    private Date createDate;

    private Date modifyDate;

    @Transient
    private List<AdditionAttribute> attributeArrayList = new ArrayList<>();  //加成属性

    @Transient
    private List<BasicAttribute> basicAttributeList = new ArrayList<>();  //基本属性

    private Boolean deleted = false;
}
