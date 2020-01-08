package com.ybs.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Forecast
 *
 * @author Paulson
 * @date 2020/1/8 21:58
 */
@Data
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
