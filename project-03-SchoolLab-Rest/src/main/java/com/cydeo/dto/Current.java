package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Current {
    @JsonProperty("observation_time")
    String observation_time;
    @JsonProperty("temperature")
    int temperature;
    @JsonProperty("weather_code")
    int weather_code;
    @JsonProperty("weather_icons")
    List<String> weather_icons;
    @JsonProperty("weather_descriptions")
    List<String> weather_descriptions;
    @JsonProperty("wind_speed")
    int wind_speed;
    @JsonProperty("wind_degree")
    int wind_degree;
    @JsonProperty("wind_dir")
    String wind_dir;
    @JsonProperty("pressure")
    int pressure;
    @JsonProperty("precip")
    int precip;
    @JsonProperty("humidity")
    int humidity;
    @JsonProperty("cloudcover")
    int cloudcover;
    @JsonProperty("feelslike")
    int feelslike;
    @JsonProperty("uv_index")
    int uv_index;
    @JsonProperty("visibility")
    int visibility;
    @JsonProperty("is_day")
    String is_day;
}