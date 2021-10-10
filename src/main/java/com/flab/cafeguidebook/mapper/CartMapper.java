package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.CartItem;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

  public int insertCartItem(@Param("userId") Long userId,
      @Param("cartItem") CartItem cartItem);

  public List<CartItem> selectCartItems(@Param("userId") Long userId);

  public int removeUsersCartItems(@Param("userId") Long userId);
}
