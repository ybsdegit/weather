package com.ybs.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Yesterday
 *
 * @author Paulson
 * @date 2020/1/8 21:58
 */

@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
