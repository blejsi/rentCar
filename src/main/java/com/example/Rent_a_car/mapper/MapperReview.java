package com.example.Rent_a_car.mapper;


import org.springframework.stereotype.Component;

@Component
public class MapperReview {

    public Review mapToEntity(RequestReviewDto requestReviewDto) {
        return Review.builder()
                .reviewerName(requestReviewDto.getReviewerName())
                .comment(requestReviewDto.getComment())
                .rating(requestReviewDto.getRating())
                .createdDate(requestReviewDto.getCreatedDate())
                .build();
    }

    public ResponseReviewDto mapToResponse(Review review) {
        ResponseReviewDto responseReviewDto = new ResponseReviewDto();
        responseReviewDto.setId(review.getId());
        responseReviewDto.setReviewerName(review.getReviewerName());
        responseReviewDto.setComment(review.getComment());
        responseReviewDto.setRating(review.getRating());
        responseReviewDto.setCreatedDate(review.getCreatedDate());

        //  if (review.getCar() != null) {
        //    responseReviewDto.setCarName(review.getCar().getName());
        //}

        return responseReviewDto;
    }
}