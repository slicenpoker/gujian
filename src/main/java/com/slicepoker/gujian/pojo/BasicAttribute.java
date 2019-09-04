package com.slicepoker.gujian.pojo;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_basic_attribute")
public class BasicAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentCode; //装备code

    private String AttributeCode;  //属性名称Code

    private double basicAttributeNumber; //基础属性数值

    private boolean deleted = false;
}
