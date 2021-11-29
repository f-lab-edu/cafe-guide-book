package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dao.CartItemDAO;
import com.flab.cafeguidebook.domain.CartItem;
import com.flab.cafeguidebook.domain.Order;
import com.flab.cafeguidebook.domain.OrderMenu;
import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.mapper.OrderMapper;
import com.flab.cafeguidebook.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private CartItemDAO cartItemDAO;
  @Autowired
  private OrderMapper orderMapper;
  @Autowired
  private UserMapper userMapper;

  public void createOrder(Long userId, Long cafeId) {
    User user = userMapper.selectUserById(userId);
    Order order = Order.builder()
        .userId(userId)
        .cafeId(cafeId)
        .address(user.getAddress())
        .build();

    Long orderId = orderMapper.insertOrder(order);
    List<CartItem> cartItemList = cartItemDAO.selectCartList(userId);

    addOrderMenu(cartItemList, orderId);
    cartItemDAO.deleteMenuList(userId);
  }

  private void addOrderMenu(List<CartItem> cartItemList, Long orderId) {
    List<OrderMenu> orderMenuList = new ArrayList<>();
    cartItemList.forEach(cartItem -> {
      orderMenuList.add(
          OrderMenu.builder()
              .menuId(cartItem.getMenuId())
              .orderId(orderId)
              .count(cartItem.getCount())
              .build()
      );
    });
    orderMapper.insertOrderMenus(orderMenuList);
  }
}
