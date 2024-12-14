package com.example.Rent_a_car.mapper;

import com.example.Rent_a_car.CategoryDTO.RequestCategoryDto;
import com.example.Rent_a_car.CategoryDTO.ResponseCategoryDto;
import com.example.Rent_a_car.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(RequestCategoryDto requestCategoryDto) {

        return Category.builder()
                .name(requestCategoryDto.getName())
                .paxCapacity(requestCategoryDto.getPaxCapacity())
                .build();
    }

    public ResponseCategoryDto mapToResponse(Category category) {
        ResponseCategoryDto responseCategoryDto = new ResponseCategoryDto();
        responseCategoryDto.setId(category.getId());
        responseCategoryDto.setName(category.getName());
        responseCategoryDto.setPaxCapacity(category.getPaxCapacity());

        return responseCategoryDto;
    }
}
