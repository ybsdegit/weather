package com.ybs.weather.controller;

import com.ybs.weather.service.CityDataService;
import com.ybs.weather.service.WeatherReportService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello
 *
 * @author Paulson
 * @date 2020/1/8 21:49
 */
@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;

    @SneakyThrows
    @GetMapping("/weather")
    public String getReportByCityId2(@RequestParam(name = "cityId", defaultValue = "101010100", required = false) String cityId, Model model) {
        model.addAttribute("title", "Paulson 的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return "report";
    }
}
