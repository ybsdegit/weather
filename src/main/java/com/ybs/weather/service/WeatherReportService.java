package com.ybs.weather.service;

import com.ybs.weather.vo.Weather;
import org.springframework.stereotype.Service;

/**
 * Weather Report Service
 *
 * @author Paulson
 * @date 2020/1/9 1:20
 */

public interface WeatherReportService {

    /**
     * 根据城市id查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
