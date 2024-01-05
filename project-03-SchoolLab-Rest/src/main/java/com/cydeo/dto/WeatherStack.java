package com.cydeo.dto;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "request",
        "location",
        "current"
})
@Generated("jsonschema2pojo")
public class WeatherStack {

    @JsonProperty("request")
    public Request request;
    @JsonProperty("location")
    public Location location;
    @JsonProperty("current")
    public Current current;

}