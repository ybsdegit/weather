package com.ybs.weather.vo;

import lombok.Data;

/**
 * WeatherResponse
 *
 * @author Paulson
 * @date 2020/1/8 22:04
 */

@Data
public class WeatherResponse {
    private Weather data;
    private String status;
    private String desc;
}
