package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainData {
    private Double temp;
    @JsonProperty("feels_like")
    private Double feels_like;
    @JsonProperty("temp_min")
    private Double temp_min;
    @JsonProperty("temp_max")
    private Double temp_max;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("sea_level")
    private Integer sea_level;
    @JsonProperty("grnd_level")
    private Integer grnd_level;


}
