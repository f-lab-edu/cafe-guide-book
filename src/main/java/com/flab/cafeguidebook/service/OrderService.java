package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.domain.CartItem;
import com.flab.cafeguidebook.domain.Order;
import com.flab.cafeguidebook.domain.OrderMenu;
import com.flab.cafeguidebook.domain.User;
import com.flab.cafeguidebook.mapper.CartMapper;
import com.flab.cafeguidebook.mapper.OrderMapper;
import com.flab.cafeguidebook.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private OrderMapper orderMapper;

  @Autowired
  private CartMapper cartMapper;

  @Autowired
  private UserMapper userMapper;

  public void createOrder(Long userId, Long cafeId) {
    // 1. userId를 통해 장바구니 리스트들을 가져온다.
    // 2. addOrderMenu 메서드 안에서 카트의 내용을 OrderMenu로 매핑해서 인서트 한다.
    // 3. 유저가 장바구니에 담은 주문 리스트를 삭제한다.
    User user = userMapper.selectUserById(userId);
    Order order = Order.builder()
        .userId(userId)
        .cafeId(cafeId)
        .address(user.getAddress())
        .build();

    Long orderId = orderMapper.insertOrder(order);
    List<CartItem> cartItemList = cartMapper.selectCartItems(userId);

    addOrderMenu(cartItemList, orderId);
    cartMapper.removeUsersCartItems(userId);
  }

  private void addOrderMenu(List<CartItem> cartItemList, Long orderId) {
    // 장바구니에서부터 주문을 가져와서 주문 오브젝트를 생성한다.
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
