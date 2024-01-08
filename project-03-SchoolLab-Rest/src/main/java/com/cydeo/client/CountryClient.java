package com.cydeo.client;

import com.cydeo.dto.country.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;
import java.util.List;


@FeignClient(url = "https://restcountries.com", name = "COUNTRY-CLIENT")
public interface CountryClient {
    @GetMapping("v3.1/name/{country}")
    Country[] getFlags(@PathVariable String country);
}
