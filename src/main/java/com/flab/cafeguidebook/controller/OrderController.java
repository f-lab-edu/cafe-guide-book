package com.flab.cafeguidebook.controller;


import com.flab.cafeguidebook.annotation.SignInCheck;
import com.flab.cafeguidebook.dto.OrderDTO;
import com.flab.cafeguidebook.service.OrderService;
import com.flab.cafeguidebook.util.SessionKeys;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping(value = "/cafes/{cafeId}/orders")
  @SignInCheck
  public void createOrder(@RequestBody OrderDTO order, @PathVariable Long cafeId,
      HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    orderService.createOrder(cafeId, userId);
  }
}
