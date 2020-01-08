package com.ybs.weather.job;

import com.ybs.weather.service.CityDataService;
import com.ybs.weather.service.WeatherDataService;
import com.ybs.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisPipelineException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * WeatherDataSyncJob
 * 天气数据重试
 * @author Paulson
 * @date 2020/1/9 0:20
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start! ");
        // 获取城市ID列表
        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.info("error", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityid: {}", cityId);

            weatherDataService.syncDataByCityId(cityId);
        }
        log.info("Weather Data Sync Job. END! ");
    }
}
