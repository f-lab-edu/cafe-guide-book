package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.annotation.SignInCheck;
import com.flab.cafeguidebook.service.HeartService;
import com.flab.cafeguidebook.util.SessionKeys;
import javax.servlet.http.HttpSession;
import com.flab.cafeguidebook.service.HeartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class HeartController {

  @Autowired
  private HeartService heartService;

  @SignInCheck
  @PostMapping("/cafes/{cafeId}/hearts")
  public void addHeart(@PathVariable Long cafeId, HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    heartService.addHeart(userId, cafeId);
  }

  @SignInCheck
  @DeleteMapping("/cafes/{cafeId}/hearts")
  public void removeHeart(@PathVariable Long cafeId, HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    heartService.removeHeart(userId, cafeId);
  }
}
