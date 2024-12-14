package com.example.Rent_a_car.mapper;

import com.example.Rent_a_car.CarDTO.CarRequestDto;
import com.example.Rent_a_car.CarDTO.CarResponseDto;
import com.example.Rent_a_car.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapping {

    public Car mapToEntity(CarRequestDto carRequestDto) {
        Car car = Car.builder()
                .brand(carRequestDto.getBrand())
                .model(carRequestDto.getModel())
                .bodyType(carRequestDto.getBodyType())
                .colour(carRequestDto.getColour())
                .mileage(carRequestDto.getMileage())
                .year(carRequestDto.getYear())
                .amount(carRequestDto.getAmount()).build();

        return car;



//        private String model;
//        private String bodyType;
//        private String colour;
//        private Double mileage;
//        private Integer year;
//        private Double amount;
    }


    public CarResponseDto mapToResponse(Car cars){
           CarResponseDto carResponseDto = new CarResponseDto();
           carResponseDto.setId(cars.getId());
           carResponseDto.setBrand(cars.getBrand());
           carResponseDto.setModel(cars.getModel());
           carResponseDto.setBodyType(cars.getBodyType());
           carResponseDto.setColour(cars.getColour());
           carResponseDto.setMileage(cars.getMileage());
           carResponseDto.setYear(cars.getYear());
           carResponseDto.setAmount(cars.getAmount());
           return carResponseDto;


    }
}
