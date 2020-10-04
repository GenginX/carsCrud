package com.kaczmarm.Cars.controller;

import com.kaczmarm.Cars.exception.IncorrectInformationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarAdviseHandler {

    @ExceptionHandler(IncorrectInformationException.class)
    public ResponseEntity<String>incorrectInformationHandler(IncorrectInformationException e){
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(e.getMessage());
    }

}
