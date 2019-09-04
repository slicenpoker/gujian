package com.slicepoker.gujian.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_basic_name")
public class AttributeName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String attributeName;  //属性名称

    private String attributeCode; //属性code

    private String typeCode; //类型code

    private Date createDate;  //创建时间

    private Date modifyDate; //修改时间

    private boolean deleted = false;
}
