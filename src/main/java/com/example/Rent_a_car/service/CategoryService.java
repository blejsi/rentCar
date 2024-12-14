package com.example.Rent_a_car.service;


import com.example.Rent_a_car.CategoryDTO.RequestCategoryDto;
import com.example.Rent_a_car.CategoryDTO.ResponseCategoryDto;
import com.example.Rent_a_car.mapper.CategoryMapper;
import com.example.Rent_a_car.model.Category;
import com.example.Rent_a_car.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryMapper mapper;

    public List<ResponseCategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<ResponseCategoryDto> responseCategoryDtoList = categoryList.stream()
                .map(cat->mapper.mapToView(cat)).toList();
           return responseCategoryDtoList;
    }

    public ResponseCategoryDto findCategoryByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("This category id does not exist!"));
        return mapper.mapToView(category);
    }

    public String deleteCategoryById(Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This category id does not exist!"));
        categoryRepository.delete(existingCategory);
        return "Car category with id " +id+ " deleted";
    }

    public ResponseCategoryDto updateCategory(RequestCategoryDto requestCategoryDto,String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("This category id does not exist!"));

        category.setName(requestCategoryDto.getName());
        category.setPaxCapacity(requestCategoryDto.getPaxCapacity());

        Category updatedCategory = categoryRepository.save(category);
        return mapper.mapToView(updatedCategory);


    }


}
