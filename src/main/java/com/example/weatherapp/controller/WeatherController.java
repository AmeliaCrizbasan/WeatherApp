package com.example.weatherapp.controller;

import com.example.weatherapp.dto.*;
import com.example.weatherapp.exception.CityNotFoundException;
import com.example.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping(path = "/{city}")
    public ResponseEntity<WeatherDTO> addWeather(@PathVariable String city) {
        WeatherDTO weather = weatherService.saveWeather(city);
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

    @GetMapping(path = "/{city}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<CurrentWeather> getWeatherForCity(@PathVariable String city) throws CityNotFoundException {
        CurrentWeather currentWeather = weatherService.getWeatherForCity(city);
        if (!currentWeather.getCod().equals("200")) {
            throw new CityNotFoundException();
        } else {
            return new ResponseEntity<>(weatherService.getWeatherForCity(city), HttpStatus.OK);
        }
    }

    @GetMapping(path = "/avg/{city}")
    public ResponseEntity<Avg> getAvgWeather(@PathVariable String city) {
        Avg avg = weatherService.avg(city);
        return new ResponseEntity<>(avg, HttpStatus.OK);
    }

    @PostMapping(path = "/saveWeather")
    public ResponseEntity<WeatherResponse> saveWeather(@RequestBody WeatherRequest request) {
        WeatherResponse weather = weatherService.saveWeatherApp(request);
        return new ResponseEntity<>(weather, HttpStatus.OK);
    }

}
