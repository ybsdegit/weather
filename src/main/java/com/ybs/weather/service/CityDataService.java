package com.ybs.weather.service;

import com.ybs.weather.vo.City;

import java.util.List;

/**
 * City Data Service
 *
 * @author Paulson
 * @date 2020/1/9 0:45
 */
public interface CityDataService {

    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;

}
