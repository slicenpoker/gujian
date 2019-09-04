package com.slicepoker.gujian.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_addition_attribute")
@Data
public class AdditionAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String equipmentCode; //装备code

    private String basicNameCode;  //属性名称Code

    private double additionAttributeNumber; //基础属性数值

    private boolean deleted = false;
}
