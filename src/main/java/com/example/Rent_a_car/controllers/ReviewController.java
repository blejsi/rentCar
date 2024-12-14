package com.example.Rent_a_car.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/save")
    public ResponseReviewDto save(@RequestBody RequestReviewDto requestReviewDto) {
        return reviewService.save(requestReviewDto);
    }

    @GetMapping("/findAll")
    public List<ResponseReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ResponseReviewDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
    @PutMapping("update/{id}")
    public ResponseReviewDto update(@PathVariable Long id,@RequestBody RequestReviewDto requestReviewDto){
        return  reviewService.updateReview(id,requestReviewDto);
    }

}
