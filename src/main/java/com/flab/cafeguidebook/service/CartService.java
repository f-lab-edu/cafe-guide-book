package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dao.CartItemDAO;
import com.flab.cafeguidebook.domain.CartItem;
import com.flab.cafeguidebook.dto.CartItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

  @Autowired
  private CartItemDAO cartItemDAO;

  public void addCartItem(Long userId, CartItemDTO cartItemDTO) {
    CartItem cartItem = CartItem.builder()
        .id(cartItemDTO.getId())
        .name(cartItemDTO.getName())
        .price(cartItemDTO.getId())
        .cafeId(cartItemDTO.getCafeId())
        .menuId(cartItemDTO.getMenuId())
        .count(cartItemDTO.getCount())
        .build();

    cartItemDAO.insertCartItem(userId, cartItem);
  }
}
