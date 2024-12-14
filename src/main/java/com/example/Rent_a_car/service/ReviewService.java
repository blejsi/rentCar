package com.example.Rent_a_car.service;


import com.example.Rent_a_car.DTO.RequestReviewDto;
import com.example.Rent_a_car.DTO.ResponseReviewDto;
import com.example.Rent_a_car.mapper.MapperReview;
import com.example.Rent_a_car.model.Car;
import com.example.Rent_a_car.model.Review;
import com.example.Rent_a_car.repository.CarRepository;
import com.example.Rent_a_car.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private  ReviewRepository reviewRepository;
    private  MapperReview mapper;
    private CarRepository carRepository;

    public List<ResponseReviewDto> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(mapper::mapToView).toList();
    }

    public ResponseReviewDto findById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        return mapper.mapToView(review);
    }

    public ResponseReviewDto save(RequestReviewDto requestReviewDto) {
        Car existingCar = carRepository.findById(requestReviewDto.getCarId())
                .orElseThrow(() -> new RuntimeException
                        ("Car not found  " ));


        Review review = mapper.mapToEntity(requestReviewDto);
        review.setCar(existingCar);
        Review savedReview = reviewRepository.save(review);
        return mapper.mapToView(savedReview);
    }

    public void deleteById(Long id) {


        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found with ID: " + id));
        reviewRepository.delete(review);
    }


    public ResponseReviewDto updateReview(Long id,RequestReviewDto requestReviewDto) {
       Car existingCar = carRepository.findByBrandAndModel(requestReviewDto.getBrand(), requestReviewDto.getModel())
               .orElseThrow(()-> new RuntimeException("Car not found with ID: " + id));

        Review review = reviewRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Review not found with ID: " + id));

        review.setReviewerName(requestReviewDto.getReviewerName());
        review.setComment(requestReviewDto.getComment());
        review.setRating(requestReviewDto.getRating());
        review.setCreatedDate(requestReviewDto.getCreatedDate());
        review.setCar(existingCar);


        Review savedReview = reviewRepository.save(review);
        return mapper.mapToView(savedReview);
    }


}
