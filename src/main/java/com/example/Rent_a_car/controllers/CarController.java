package com.example.Rent_a_car.controller;

import com.example.Rent_a_car.DTO.CarRequestDto;
import com.example.Rent_a_car.DTO.CarResponseDto;
import com.example.Rent_a_car.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/get")
    public List<CarResponseDto> findAll() {
        return carService.findAll();
    }

    @GetMapping("/getById/{id}")
    public CarResponseDto findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping("/save")
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

