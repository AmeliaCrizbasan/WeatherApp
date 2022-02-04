package com.example.weatherapp.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@ControllerAdvice
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {


    public void handleError(ClientHttpResponse response) throws IOException {

//            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new NotFoundException();
//            }

    }

//    @ExceptionHandler({CityNotFoundException.class})
//    protected ResponseEntity<ApiError> handleError(Exception ex){
//        ApiError apiError = new ApiError();
//        apiError.setMessage(ex.getMessage());
//        apiError.setStatus(HttpStatus.NOT_FOUND);
//
//        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
//    }
}
