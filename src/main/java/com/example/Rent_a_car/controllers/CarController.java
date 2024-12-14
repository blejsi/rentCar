package com.example.Rent_a_car.controllers;

import com.example.Rent_a_car.CarDTO.CarRequestDto;
import com.example.Rent_a_car.CarDTO.CarResponseDto;
import com.example.Rent_a_car.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
@AllArgsConstructor
@Controller
public class CarController {

    private final CarService carService;

    @GetMapping("/get")
    public List<CarResponseDto> findAll() {
        return carService.findAll();
    }


 @GetMapping("/get/{id}")
    public CarResponseDto findById(@PathVariable Long id){
        return carService.findById(id);
    }


    @PostMapping("/add")
    public CarResponseDto save(@RequestBody CarRequestDto carRequestDto) {
        return carService.save(carRequestDto);
    }

    @PutMapping("/update/{id}")
    public CarResponseDto update(@PathVariable Long id, @RequestBody CarRequestDto carRequestDto) {
        return carService.update(id, carRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return carService.delete(id);
    }
}

