package com.ybs.weather.service;

import com.ybs.weather.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * WeatherDataService
 *
 * @author Paulson
 * @date 2020/1/8 22:06
 */
public interface WeatherDataService {

    /**
         * 根据城市id来查询天气数据
         *
         * @param cityId
         * @return
         */
    WeatherResponse getDataByCityId(String cityId);
    /**
     * 根据城市名称来查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 通过城市Id来同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);

}
