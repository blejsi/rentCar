package com.example.Rent_a_car.mapper;


import com.example.Rent_a_car.DTO.RequestReviewDto;
import com.example.Rent_a_car.DTO.ResponseReviewDto;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.model.Review;
import com.example.Rent_a_car.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class MapperReview {

    private  CarRepository carRepository;

    public Review mapToEntity(RequestReviewDto requestReviewDto) {

       Review review = new Review();
       requestReviewDto.setReviewerName(requestReviewDto.getReviewerName());
       requestReviewDto.setComment(review.getComment());
       requestReviewDto.setRating(review.getRating());
       requestReviewDto.setCreatedDate(review.getCreatedDate());


        Car car = carRepository.findById(requestReviewDto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));


        review.setCar(car);


       return review;
    }

    public ResponseReviewDto mapToView(Review review) {

        ResponseReviewDto responseReviewDto = new ResponseReviewDto();

        responseReviewDto.setId(review.getId());
        responseReviewDto.setReviewerName(review.getReviewerName());
        responseReviewDto.setComment(review.getComment());
        responseReviewDto.setRating(review.getRating());
        responseReviewDto.setCreatedDate(review.getCreatedDate());
        responseReviewDto.setCarId(review.getCar().getId());
        responseReviewDto.setBrand(review.getCar().getBrand());
        responseReviewDto.setModel(review.getCar().getModel());
        responseReviewDto.setBodyType(review.getCar().getBodyType());
        responseReviewDto.setColour(review.getCar().getColour());
        responseReviewDto.setMileage(review.getCar().getMileage());
        responseReviewDto.setYear(review.getCar().getYear());
        responseReviewDto.setAmount(review.getCar().getAmount());





        return responseReviewDto;
    }
}