package com.example.weatherapp.service;

import com.example.weatherapp.dto.*;
import com.example.weatherapp.exception.CityNotFoundException;

public interface WeatherService {
    CurrentWeather getWeatherForCity(String city) throws CityNotFoundException;

    WeatherDTO saveWeather(String city);

    Avg avg(String city);

    WeatherResponse saveWeatherApp(WeatherRequest request);

}
