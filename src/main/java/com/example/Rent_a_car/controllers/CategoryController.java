package com.example.Rent_a_car.controllers;

import com.example.Rent_a_car.dto.RequestCategoryDto;
import com.example.Rent_a_car.dto.ResponseCategoryDto;
import com.example.Rent_a_car.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/save")
public ResponseEntity<ResponseCategoryDto> save(@RequestBody RequestCategoryDto requestCategoryDto){
return new ResponseEntity<>(categoryService.save(requestCategoryDto), HttpStatus.CREATED);
    }

@GetMapping("/findAll")
public ResponseEntity<List<ResponseCategoryDto>> findAll(){

        return ResponseEntity.ok(categoryService.findAll());
}

}
