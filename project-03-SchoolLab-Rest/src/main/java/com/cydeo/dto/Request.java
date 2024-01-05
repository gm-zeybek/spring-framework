package com.cydeo.dto;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "type",
        "query",
        "language",
        "unit"
})
@Generated("jsonschema2pojo")
public class Request {

    @JsonProperty("type")
    public String type;
    @JsonProperty("query")
    public String query;
    @JsonProperty("language")
    public String language;
    @JsonProperty("unit")
    public String unit;

}
