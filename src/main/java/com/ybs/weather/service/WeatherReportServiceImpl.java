package com.ybs.weather.service;

import com.ybs.weather.vo.Weather;
import com.ybs.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WeatherReportServiceImpl
 *
 * @author Paulson
 * @date 2020/1/9 1:22
 */

@Service
public class WeatherReportServiceImpl implements  WeatherReportService{

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse res = weatherDataService.getDataByCityId(cityId);
        return res.getData();
    }
}
