package com.flab.cafeguidebook.controller;


import com.flab.cafeguidebook.annotation.SignInCheck;
import com.flab.cafeguidebook.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafes/{cafeId}/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping
  @SignInCheck
  public void createOrder(@PathVariable Long cafeId) {
  }
}
