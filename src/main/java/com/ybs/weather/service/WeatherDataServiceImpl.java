package com.ybs.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybs.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * WeatherDataServiceImpl 实现类
 *
 * @author Paulson
 * @date 2020/1/8 22:08
 */

/**
 * 通过城市名称获得天气数据：http://wthrcdn.etouch.cn/weather_mini?city=北京
 * <p>
 * 通过城市id获得天气数据：http://wthrcdn.etouch.cn/weather_mini?citykey=101280601
 * <p>
 * 城市id列表
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 3600L;  // 30m

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(url);
    }

    //http://wthrcdn.etouch.cn/weather_mini?太原
//http://wthrcdn.etouch.cn/weather_mini?city=北京
    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(url);
    }


    private WeatherResponse doGetWeather(String uri) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        String strBody = null;

        ValueOperations ops = redisTemplate.opsForValue();

        if (redisTemplate.hasKey(uri)) {
            log.info("Redis has data");
            strBody = (String) ops.get(uri);
        } else {
            log.info("Redis don't has data");
            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            log.info("response info:{}", respString);
            if (respString.getStatusCodeValue() == 200) {
                strBody = respString.getBody();
            }
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (Exception e) {
            log.error("error", e);
        }
        return weather;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String url = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(url);
    }

    /**
     * 把天气数据放入缓存中
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        ValueOperations ops = redisTemplate.opsForValue();

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        log.info("response info: {}", respString);
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        if (!redisTemplate.hasKey(uri)){
            ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
        }

    }
}
