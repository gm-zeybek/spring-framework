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
public class Request {
    @JsonProperty("type")
    String type;
    @JsonProperty("query")
    String query;
    @JsonProperty("language")
    String language;
    @JsonProperty("unit")
    String unit;
}