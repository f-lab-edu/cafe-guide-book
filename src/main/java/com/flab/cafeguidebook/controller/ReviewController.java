package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.dto.ReviewDTO;
import com.flab.cafeguidebook.service.ReviewService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReviewController {

  private static final Logger LOGGER = LogManager.getLogger(ReviewController.class);

  @Autowired
  private ReviewService reviewService;

  @PostMapping(value = "cafes/{cafeId}/reviews", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity addReivew(@RequestBody @Validated ReviewDTO reviewDTO,
      @PathVariable Long cafeId,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      bindingResult.getAllErrors().forEach(error -> {
        LOGGER.info(error);
      });
      return ResponseEntity.badRequest().build();
    }
    reviewService.addReview(cafeId, reviewDTO);
    return ResponseEntity.ok(reviewDTO);
  }

  @GetMapping(value = "/users/{userId}/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ReviewDTO> getReviews(@PathVariable Long userId) {
    return reviewService.getUsersReviews(userId);
  }

  @GetMapping(value = "/cafes/{cafeId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ReviewDTO> getCafesReviews(@PathVariable Long cafeId) {
    return reviewService.getCafesReviews(cafeId);
  }
}
