package com.flab.cafeguidebook.controller;

import com.flab.cafeguidebook.annotation.SignInCheck;
import com.flab.cafeguidebook.dto.CartItemDTO;
import com.flab.cafeguidebook.service.CartService;
import com.flab.cafeguidebook.util.SessionKeys;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/{userId}/carts")
public class CartController {

  @Autowired
  private CartService cartService;

  @PostMapping
  @SignInCheck
  public void addCartItem(@RequestBody CartItemDTO cartItemDTO, HttpSession httpSession) {
    Long userId = (Long) httpSession.getAttribute(SessionKeys.USER_ID);
    cartService.addCartItem(userId, cartItemDTO);
  }
}
