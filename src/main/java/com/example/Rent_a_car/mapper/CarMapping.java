package com.example.Rent_a_car.mapper;

import com.example.Rent_a_car.CarDTO.CarRequestDto;
import com.example.Rent_a_car.CarDTO.CarResponseDto;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.model.Category;
import com.example.Rent_a_car.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class CarMapping {



    public Car mapToEntity(CarRequestDto carRequestDto) {

        Category category = new Category();
        Car carEntity = new Car();


        carEntity.setBrand(carRequestDto.getBrand());
        carEntity.setModel(carRequestDto.getModel());
        carEntity.setBodyType(carRequestDto.getBodyType());
        carEntity.setColour(carRequestDto.getColour());
        carEntity.setMileage(carRequestDto.getMileage());
        carEntity.setYear(carRequestDto.getYear());
        carEntity.setAmount(carRequestDto.getAmount());
        carEntity.setCategory(category);


        return carEntity;




    }


    public CarResponseDto mapToView(Car cars){
           CarResponseDto carResponseDto = new CarResponseDto();

           carResponseDto.setId(cars.getId());
           carResponseDto.setBrand(cars.getBrand());
           carResponseDto.setModel(cars.getModel());
           carResponseDto.setBodyType(cars.getBodyType());
           carResponseDto.setColour(cars.getColour());
           carResponseDto.setMileage(cars.getMileage());
           carResponseDto.setYear(cars.getYear());
           carResponseDto.setAmount(cars.getAmount());
           carResponseDto.setCategoryId(cars.getCategory().getId());
           carResponseDto.setCategoryName(cars.getCategory().getName());
           carResponseDto.setCategoryPaxCapacity(cars.getCategory().getPaxCapacity());
           return carResponseDto;


    }
}
