package com.ybs.weather.config;

import com.ybs.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QuartzConfiguration
 * 配置
 * @author Paulson
 * @date 2020/1/9 0:22
 */

@Configuration
public class QuartzConfiguration {

    private static final int TIME = 3600;

    // JobDetail 特定job
    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("WeatherDataSyncJob")
                .storeDurably()
                .build();
    }

    // Trigger 触发
    @Bean
    public Trigger weatherDataSyncTrigger(){

        SimpleScheduleBuilder scheduleBuilder =  SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(TIME)
                .repeatForever();  // 每隔办个小时重复执行一次

        return TriggerBuilder.newTrigger()
                .forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }


}
