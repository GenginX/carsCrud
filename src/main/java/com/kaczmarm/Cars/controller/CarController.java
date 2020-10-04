package com.kaczmarm.Cars.controller;

import com.kaczmarm.Cars.model.Car;
import com.kaczmarm.Cars.model.CarDto;
import com.kaczmarm.Cars.service.CarService;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(allCars);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody CarDto car) throws JSONException {
        Car carCreated = carService.saveCar(car);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carCreated);
    }

}
