package com.example.Rent_a_car.mapper;


import com.example.Rent_a_car.CategoryDTO.ResponseCategoryDto;
import com.example.Rent_a_car.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category mapToEntity(ResponseCategoryDto responseCategoryDto) {

        return Category.builder()
                .name(responseCategoryDto.getName())
                .paxCapacity(responseCategoryDto.getPaxCapacity())
                .build();
    }

    public ResponseCategoryDto mapToView(Category category) {
        ResponseCategoryDto responseCategoryDto = new ResponseCategoryDto();
        category.setId(responseCategoryDto.getId());
        category.setName(responseCategoryDto.getName());
        category.setPaxCapacity(responseCategoryDto.getPaxCapacity());

        return responseCategoryDto;
    }
}
