package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @JsonProperty("name")
    String name;
    @JsonProperty("country")
    String country;
    @JsonProperty("region")
    String region;
    @JsonProperty("lat")
    String lat;
    @JsonProperty("lon")
    String lon;
    @JsonProperty("timezone_id")
    String timezone_id;
    @JsonProperty("localtime")
    String localtime;
    @JsonProperty("localtime_epoch")
    int localtime_epoch;
    @JsonProperty("utc_offset")
    String utc_offset;
}