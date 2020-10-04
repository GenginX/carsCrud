package com.kaczmarm.Cars.model;

import lombok.Data;

@Data
public class CarDto {

    private String brand;

    private String model;

    private String year;

    private Long userId;
}
