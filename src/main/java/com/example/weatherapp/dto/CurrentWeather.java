package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CurrentWeather {

    private Set<Weather> weather = new HashSet<>();
    private MainData main;
    private String cod;
    private String message;

}
