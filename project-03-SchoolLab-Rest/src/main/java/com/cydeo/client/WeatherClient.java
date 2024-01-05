package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;


// TODO: THEN ADD @FeignClient ANNOTATION WITH URL AND NAME
@FeignClient(url = "http://api.weatherstack.com/current", name = "WEATHER-CLIENT")
public interface WeatherClient {

    @GetMapping()
    Object getCurrent(@RequestHeader Map<String, String> headers); // TODO: FINALLY ADD RELATED HEADERS AND QUERY OR PATH PARAMS


}
