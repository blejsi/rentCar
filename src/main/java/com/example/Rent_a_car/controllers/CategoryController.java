package com.example.Rent_a_car.controllers;

import com.example.Rent_a_car.CategoryDTO.RequestCategoryDto;
import com.example.Rent_a_car.CategoryDTO.ResponseCategoryDto;
import com.example.Rent_a_car.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/category")
public class CategoryController {

    private CategoryService categoryService;



     @GetMapping("/findAll")
     public List<ResponseCategoryDto> findAll(){

        return categoryService.findAll();
      }

      @GetMapping
      public ResponseCategoryDto findByName(String name){
         return categoryService.findCategoryByName(name);
      }

      @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable Long id ){
         return categoryService.deleteCategoryById(id);
      }
      @PutMapping ("/update/{name}")
      public ResponseCategoryDto updateCategoryById(@RequestBody RequestCategoryDto requestCategoryDto, @PathVariable String name ){
         return categoryService.updateCategory(requestCategoryDto, name);
      }
}
