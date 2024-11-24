package com.example.Rent_a_car.controller;

import com.example.Rent_a_car.DTO.CarRequestDto;
import com.example.Rent_a_car.DTO.CarResponseDto;
import com.example.Rent_a_car.service.CarService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/rent")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class CarController {

    private CarService carService;


    @GetMapping
public List<CarResponseDto> findAll(){
    return carService.findAll();
}


 @GetMapping
    public CarResponseDto findById(@RequestBody Long id){
        return carService.findById(id);
    }


       @PostMapping
    public CarResponseDto save(@RequestBody CarRequestDto carRequestDto){
        return carService.save(carRequestDto);
    }



@PutMapping
public CarResponseDto update(@RequestBody Long id, CarRequestDto carRequestDto){
        return carService.update(id, carRequestDto);
}



@GetMapping
    public String delete(@RequestBody Long id){
        return carService.delete(id);
    }



}
