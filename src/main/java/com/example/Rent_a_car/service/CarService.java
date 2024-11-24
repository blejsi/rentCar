package com.example.Rent_a_car.service;


import com.example.Rent_a_car.DTO.CarRequestDto;
import com.example.Rent_a_car.DTO.CarResponseDto;
import com.example.Rent_a_car.mapping.CarMapping;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CarService {


    private  CarMapping carMapping;
    private CarRepository carRepository;

    @Autowired
    public CarService(CarMapping carMapping) {
        this.carMapping = carMapping;
    }

    public List<CarResponseDto> findAll(){
       List<Car> carList = carRepository.findAll();

       List<CarResponseDto> carResponseDtoList = new ArrayList<>();

       for (Car c : carList) {

           carResponseDtoList.add(carMapping.mapToResponse(c));

       }
       return carResponseDtoList;

    }


    public CarResponseDto findById(Long id) {

       Car car = carRepository.findById(id).orElseThrow(
               ()->new RuntimeException("This entity not found"));

       return carMapping.mapToResponse(car);

    }

    public CarResponseDto save(CarRequestDto carRequestDto) {
          Car car = carMapping.mapToEntity(carRequestDto);
          Car  car1 = carRepository.save(car);

        return carMapping.mapToResponse(car1);

    }

    public CarResponseDto update(Long id, CarRequestDto carRequestDto) {
        Car car = carRepository.findById(id).orElseThrow(
                ()->new RuntimeException("This entity not found"));
        car.setBrand(carRequestDto.getBrand());
        car.setModel(carRequestDto.getModel());
        car.setColour(carRequestDto.getColour());
        car.setYear(carRequestDto.getYear());
        car.setYear(carRequestDto.getYear());
        car.setAmount(carRequestDto.getAmount());
       Car car1 = carRepository.save(car);

       return carMapping.mapToResponse(car1);

//        private String model;
//        private String bodyType;
//        private String colour;
//        private Double mileage;
//        private Integer year;
//        private Double amount;
    }

    public String delete(Long id) {
        Car car = carRepository.findById(id).orElseThrow
                (()-> new RuntimeException("Car Not FOUND"));
        carRepository.delete(car);
        return "Car with id " + id + " deleted";
    }


}
