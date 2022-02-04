package com.example.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherResponse {
    private Integer id;
    private String city;
    private double temp;
    private Double tempMin;
    private Double tempMax;

}
