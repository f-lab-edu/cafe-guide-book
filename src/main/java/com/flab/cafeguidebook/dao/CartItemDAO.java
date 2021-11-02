package com.flab.cafeguidebook.dao;

import com.flab.cafeguidebook.domain.CartItem;
import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemDAO {

  private static final String cartKey = ":CART";
  private final RedisTemplate<String, CartItem> redisTemplate;

  public CartItemDAO(
      RedisTemplate<String, CartItem> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public static String generateCartKey(Long id) {
    return id.toString() + cartKey;
  }

  public List<CartItem> selectCartList(Long userId) {

    final String key = generateCartKey(userId);

    List<CartItem> cartList = redisTemplate
        .opsForList()
        .range(key, 0, -1);

    return cartList;
  }

  public void insertCartItem(Long userId, CartItem cart) {
    final String key = generateCartKey(userId);
    redisTemplate.opsForList().rightPush(key, cart);
  }

  public void deleteCartItemList(Long userId) {
    final String key = generateCartKey(userId);
    redisTemplate.delete(key);
  }
}
