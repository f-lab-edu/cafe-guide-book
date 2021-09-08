package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/heart")
public class HeartController {

  @Autowired
  private HeartService heartService;

  @PostMapping("/{cafeId}")
  public void addHeart(@RequestParam Long userId, @PathVariable Long cafeId) {
    heartService.addHeart(userId, cafeId);
  }

  @DeleteMapping("/{cafeId}")
  public void removeHeart(@RequestParam Long userId, @PathVariable Long cafeId) {
    heartService.removeHeart(userId, cafeId);
  }
}
