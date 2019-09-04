package com.slicepoker.gujian.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Slicen
 * @date 2019/8/16 16:16
 * @description
 */
@Data
@Entity
@Table(name = "tb_occupation")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 职业名称
     * **/
    private String occupationName;

    /**
     * 职业专精
     * */
    private String occupationMastery;
}
