package com.kaczmarm.Cars.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarView {

    private Long id;

    private String brand;

    private String model;

    private String year;

    private String username;

    private String surname;

    private int age;

}
