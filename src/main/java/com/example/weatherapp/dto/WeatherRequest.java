package com.example.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRequest {
    private String city;
    private double temp;
    private Double tempMin;
    private Double tempMax;
}
