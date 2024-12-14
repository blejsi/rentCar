package com.example.Rent_a_car.service;


import com.example.Rent_a_car.CarDTO.CarRequestDto;
import com.example.Rent_a_car.CarDTO.CarResponseDto;
import com.example.Rent_a_car.CategoryDTO.RequestCategoryDto;
import com.example.Rent_a_car.mapper.CarMapping;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.model.Category;
import com.example.Rent_a_car.repository.CarRepository;
import com.example.Rent_a_car.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {


    private  CarMapping mapping;
    private  CarRepository carRepository;
    private CategoryRepository categoryRepository;


    public List<CarResponseDto> findAll(){
       List<Car> carList = carRepository.findAll();


        return carList.stream().map(c-> mapping.mapToView(c)).toList();

    }


    public CarResponseDto findById(Long id) {

       Car car = carRepository.findById(id).orElseThrow(
               ()->new RuntimeException("This entity not found"));

       return mapping.mapToView(car);

    }

    public CarResponseDto save(CarRequestDto carRequestDto) {
        Category category = categoryRepository.findByName(carRequestDto.getCategoryName())
                .orElseGet(() -> {
                    Category newCategory = new Category();
                    newCategory.setName(carRequestDto.getCategoryName());
                    newCategory.setPaxCapacity(carRequestDto.getCategoryPaxCapacity());
                    return categoryRepository.save(newCategory);
                });

        Car car = mapping.mapToEntity(carRequestDto);
        car.setCategory(category); // Associate the category
        Car savedCar = carRepository.save(car);

        return mapping.mapToView(savedCar);
    }


    public CarResponseDto update(Long id, CarRequestDto carRequestDto) {


        Car car = carRepository.findById(id).orElseThrow(
                ()->new RuntimeException("This entity not found"));
        car.setBrand(carRequestDto.getBrand());
        car.setModel(carRequestDto.getModel());
        car.setBodyType(carRequestDto.getBodyType());
        car.setColour(carRequestDto.getColour());
        car.setYear(carRequestDto.getYear());
        car.setMileage(carRequestDto.getMileage());
        car.setAmount(carRequestDto.getAmount());

        if (carRequestDto.getCategoryName() == null || carRequestDto.getCategoryName().isBlank()) {
            throw new IllegalArgumentException("Category name must not be null or empty.");
        }

        Category category = categoryRepository.findByName(carRequestDto.getCategoryName())
                .orElseGet(()->{   Category newCategory = new Category();
                    newCategory.setName(carRequestDto.getCategoryName());
                    newCategory.setPaxCapacity(carRequestDto.getCategoryPaxCapacity());
                    return categoryRepository.save(newCategory);
                }
                );

        car.setCategory(category);

       Car car1 = carRepository.save(car);

       return mapping.mapToView(car1);

    }

    public String delete(Long id) {
        Car car = carRepository.findById(id).orElseThrow
                (()-> new RuntimeException("Car Not FOUND"));
        carRepository.delete(car);
        return "Car with id " + id + " deleted";
    }


}
