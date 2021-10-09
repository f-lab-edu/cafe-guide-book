package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartMapper {

  public int insertCartItem(@Param("userId") Long userId,
      @Param("cartItem") CartItem cartItem);
}
