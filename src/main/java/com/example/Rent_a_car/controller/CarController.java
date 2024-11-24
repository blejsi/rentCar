package com.example.Rent_a_car.controllers;

import com.example.Rent_a_car.DTO.CarRequestDto;
import com.example.Rent_a_car.DTO.CarResponseDto;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.service.CarService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CarController {

    private CarService carService;


    @GetMapping
public List<CarResponseDto> findAll(){
    return carService.findAll();
}



    public CarResponseDto findById( Long id){
        return carService.findById(id);
    }



    public CarResponseDto save(CarRequestDto carRequestDto){
        return carService.save(carRequestDto);
    }




public CarResponseDto update(Long id, CarRequestDto carRequestDto){
        return carService.update(id, carRequestDto);
}




    public String delete(Long id){
        return carService.delete(id);
    }



}
