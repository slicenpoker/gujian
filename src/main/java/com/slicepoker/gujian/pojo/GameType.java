package com.slicepoker.gujian.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_game_type")
public class GameType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;

    private String typeCode;

    private Date createDate; //创建时间

    private Date modifyDate; //修改时间

    private boolean deleted = false;
}
