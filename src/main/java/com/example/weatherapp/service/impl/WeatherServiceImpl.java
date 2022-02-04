package com.example.weatherapp.service.impl;

import com.example.weatherapp.dto.*;
import com.example.weatherapp.exception.CityNotFoundException;
import com.example.weatherapp.exception.RestTemplateResponseErrorHandler;
import com.example.weatherapp.repository.WeatherRepository;
import com.example.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final String URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String API_ID = "5e0bf7a6dbffb8c3503bf82198b2aa34";
    private final WeatherRepository weatherRepository;

    public WeatherDTO saveWeather(String city) {

        String url = URL + "?q=" + city + "&units=metric" + "&appid=" + API_ID;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class);

        WeatherDTO weather = new WeatherDTO();
        weather.setCity(city);
        weather.setTemp(response.getBody().getMain().getTemp());
        weather.setTempMin(response.getBody().getMain().getTemp_min());
        weather.setTempMax(response.getBody().getMain().getTemp_max());


        WeatherDTO responseWeather = weatherRepository.save(weather);

        responseWeather.setCity(city);
        responseWeather.setTemp(response.getBody().getMain().getTemp());
        responseWeather.setTempMin(response.getBody().getMain().getTemp_min());
        responseWeather.setTempMax(response.getBody().getMain().getTemp_max());

        return responseWeather;

    }


    public CurrentWeather getWeatherForCity(String city) throws CityNotFoundException {
        String url = URL + "?q=" + city + "&units=metric" + "&appid=" + API_ID;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class);

        return response.getBody();
    }

    @Override
    public Avg avg(String city) {
        double avg = weatherRepository.avg(city);
        Avg response = new Avg();
        response.setAvg(avg);
        response.setCity(city);
        return response;

    }

    public WeatherResponse saveWeatherApp(WeatherRequest request) {

        WeatherDTO weather = new WeatherDTO();
        weather.setCity(request.getCity());
        weather.setTemp(request.getTemp());
        weather.setTempMin(request.getTempMin());
        weather.setTempMax(request.getTempMax());

        WeatherDTO responseWeather = weatherRepository.save(weather);

        WeatherResponse weatherResponse = new WeatherResponse();

        weatherResponse.setId(responseWeather.getId());
        weatherResponse.setCity(responseWeather.getCity());
        weatherResponse.setTemp(responseWeather.getTemp());
        weatherResponse.setTempMin(responseWeather.getTempMin());
        weatherResponse.setTempMax(responseWeather.getTempMax());

        return weatherResponse;
    }


}
