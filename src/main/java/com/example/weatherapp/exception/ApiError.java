package com.example.weatherapp.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiError {
    //private LocalDateTime timestamp = LocalDateTime.now();
    private HttpStatus status;
    private String cod;
    private String message;
}
