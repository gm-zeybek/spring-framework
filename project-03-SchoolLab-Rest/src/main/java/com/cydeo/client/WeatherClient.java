package com.cydeo.client;

import com.cydeo.dto.WeatherStack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// TODO: THEN ADD @FeignClient ANNOTATION WITH URL AND NAME
@FeignClient(url = "http://api.weatherstack.com/current", name = "WEATHER-CLIENT")
public interface WeatherClient {
    // TODO: FINALLY ADD RELATED HEADERS AND QUERY OR PATH PARAMS
    @GetMapping()
    WeatherStack getCurrentTemperature(@RequestParam("access_key") String access_key, @RequestParam("query") String city);
}
