package com.example.Rent_a_car.service;

import com.example.Rent_a_car.dto.RequestCategoryDto;
import com.example.Rent_a_car.dto.ResponseCategoryDto;
import com.example.Rent_a_car.mapper.CategoryMapper;
import com.example.Rent_a_car.model.Category;
import com.example.Rent_a_car.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;

    public List<ResponseCategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(c -> categoryMapper.mapToResponse(c)).toList();
    }

    public ResponseCategoryDto findCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This category id does not exist!"));
        return categoryMapper.mapToResponse(category);
    }

    public String deleteCategoryById(Long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("This category id does not exist!"));
        categoryRepository.delete(existingCategory);
        return "Car category with id " +id+ " deleted";
    }

    public ResponseCategoryDto save(RequestCategoryDto request) {
        Category category = categoryMapper.mapToEntity(request);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.mapToResponse(savedCategory);

    }

public ResponseCategoryDto updateCategory(Long id, RequestCategoryDto request){

    Category category = categoryRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Category with id " + id + " does not exist!"));
    category.setName(request.getName());
    category.setPaxCapacity(request.getPaxCapacity());
    Category updatedCategory = categoryRepository.save(category);

    return categoryMapper.mapToResponse(updatedCategory);
}
}
