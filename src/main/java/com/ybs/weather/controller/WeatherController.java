package com.ybs.weather.controller;

import com.ybs.weather.service.WeatherDataService;
import com.ybs.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.ParameterizedType;

/**
 * Hello
 *
 * @author Paulson
 * @date 2020/1/8 21:49
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("")
    public String  hello(){
        return "redirect:report/weather/";
    }

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

}
