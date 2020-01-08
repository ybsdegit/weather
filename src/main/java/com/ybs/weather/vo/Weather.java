package com.ybs.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Weather
 *
 * @author Paulson
 * @date 2020/1/8 21:55
 */

@Data
public class Weather implements Serializable {
    private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
