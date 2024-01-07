package com.cydeo.dto;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "observation_time",
        "temperature",
        "weather_code",
        "weather_icons",
        "weather_descriptions",
        "wind_speed",
        "wind_degree",
        "wind_dir",
        "pressure",
        "precip",
        "humidity",
        "cloudcover",
        "feelslike",
        "uv_index",
        "visibility",
        "is_day"
})
@Generated("jsonschema2pojo")
public class Current {

    @JsonProperty("observation_time")
    public String observationTime;
    @JsonProperty("temperature")
    public Integer temperature;
    @JsonProperty("weather_code")
    public Integer weatherCode;
    @JsonProperty("weather_icons")
    public List<String> weatherIcons;
    @JsonProperty("weather_descriptions")
    public List<String> weatherDescriptions;
    @JsonProperty("wind_speed")
    public Integer windSpeed;
    @JsonProperty("wind_degree")
    public Integer windDegree;
    @JsonProperty("wind_dir")
    public String windDir;
    @JsonProperty("pressure")
    public Integer pressure;
    @JsonProperty("precip")
    public Float precip;
    @JsonProperty("humidity")
    public Integer humidity;
    @JsonProperty("cloudcover")
    public Integer cloudcover;
    @JsonProperty("feelslike")
    public Integer feelslike;
    @JsonProperty("uv_index")
    public Integer uvIndex;
    @JsonProperty("visibility")
    public Integer visibility;
    @JsonProperty("is_day")
    public String isDay;

}