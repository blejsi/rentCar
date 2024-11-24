package com.example.Rent_a_car.service;


import com.example.Rent_a_car.DTO.RequestReviewDto;
import com.example.Rent_a_car.DTO.ResponseReviewDto;
import com.example.Rent_a_car.mapper.MapperReview;
import com.example.Rent_a_car.model.Review;
import com.example.Rent_a_car.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MapperReview mapperReview;

    public List<ResponseReviewDto> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(mapperReview::mapToResponse).toList();
    }

    public ResponseReviewDto findById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        return mapperReview.mapToResponse(review);
    }

    public ResponseReviewDto save(RequestReviewDto requestReviewDto) {
        Review review = mapperReview.mapToEntity(requestReviewDto);
        Review savedReview = reviewRepository.save(review);
        return mapperReview.mapToResponse(savedReview);
    }

    public void deleteById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
        reviewRepository.delete(review);
    }
}
