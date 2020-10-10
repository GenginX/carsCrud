package com.kaczmarm.Cars.service;

import com.kaczmarm.Cars.model.Car;
import com.kaczmarm.Cars.model.CarDto;
import com.kaczmarm.Cars.model.CarView;
import com.kaczmarm.Cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private RestTemplateService restTemplateService;

    public CarService(CarRepository carRepository, RestTemplateService restTemplateService) {
        this.carRepository = carRepository;
        this.restTemplateService = restTemplateService;
    }

    public Car saveCar(CarDto car) {
        Car buildedCar = Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .username(restTemplateService.getUserInformation(car.getUserId()).getName())
                .surname(restTemplateService.getUserInformation(car.getUserId()).getSurname())
                .age(restTemplateService.getUserInformation(car.getUserId()).getAge())
                .userId(car.getUserId())
                .build();
        return carRepository.save(buildedCar);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> findCarsByUserId(Long id) {
        List<Car> carByUserId = carRepository.findCarByUserId(id);
        return carByUserId;
    }

    public CarView convertCartoCarView(Car car) {
        return CarView.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .username(car.getUsername())
                .surname(car.getSurname())
                .age(car.getAge())
                .userId(car.getUserId())
                .build();

    }


}
