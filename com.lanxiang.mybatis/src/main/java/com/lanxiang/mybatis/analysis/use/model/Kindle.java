package com.lanxiang.mybatis.analysis.use.model;

import lombok.Data;

/**
 * Created by lanxiang on 2017/3/27.
 */

@Data
public class Kindle {

    private Long id;

    private String name;

    private Long price;

    private Integer version;

    private KindleSkin kindleSkin;
}
