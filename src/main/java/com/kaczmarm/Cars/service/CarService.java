package com.kaczmarm.Cars.service;

import com.kaczmarm.Cars.model.Car;
import com.kaczmarm.Cars.repository.CarRepository;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private RestTemplateService restTemplateService;

    public CarService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public Car saveCar(Car car) throws JSONException {
        Car buildedCar = Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .username(restTemplateService.getUserInformation("username"))
                .surname(restTemplateService.getUserInformation("surname"))
                .age(restTemplateService.getUserInformation("age"))
                .build();
        return carRepository.save(buildedCar);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }


}
