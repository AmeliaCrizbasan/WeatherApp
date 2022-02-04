package com.example.weatherapp.repository;

import com.example.weatherapp.dto.WeatherDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherDTO, Integer> {
    @Query(value = "SELECT COALESCE(avg(weather.temp),0) FROM weather WHERE city=:city", nativeQuery = true)
    double avg(@Param("city") String city);
}