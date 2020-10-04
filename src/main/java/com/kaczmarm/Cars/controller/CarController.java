package com.kaczmarm.Cars.controller;

import com.kaczmarm.Cars.model.Car;
import com.kaczmarm.Cars.model.CarDto;
import com.kaczmarm.Cars.model.CarView;
import com.kaczmarm.Cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<CarView>> getAllCars() {
        List<CarView> allCars = carService.getAllCars().stream()
                .map(e -> carService.convertCartoCarView(e))
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(allCars);
    }

    @PostMapping
    public ResponseEntity<CarView> createCar(@RequestBody CarDto car) {
        Car carCreated = carService.saveCar(car);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carService.convertCartoCarView(carCreated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CarView>> findCarByUserId(@PathVariable Long id) {
        List<CarView> carsByUserId = carService.findCarsByUserId(id).stream()
                .map(e -> carService.convertCartoCarView(e))
                .collect(Collectors.toList());
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(carsByUserId);
    }

}
