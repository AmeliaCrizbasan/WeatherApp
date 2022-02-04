package com.example.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "weather")
public class WeatherDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private double temp;
    private Double tempMin;
    private Double tempMax;

}
