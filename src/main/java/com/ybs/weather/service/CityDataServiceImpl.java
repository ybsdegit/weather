package com.ybs.weather.service;

import com.ybs.weather.util.XmlBuilder;
import com.ybs.weather.vo.City;
import com.ybs.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * CityDataServiceImpl
 *
 * @author Paulson
 * @date 2020/1/9 0:47
 */

@Service
public class CityDataServiceImpl implements CityDataService{
    @Override
    public List<City> listCity() throws Exception {
        // 读取xml文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null){
            buffer.append(line);
        }
        br.close();

        // xml 转为 java 对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
