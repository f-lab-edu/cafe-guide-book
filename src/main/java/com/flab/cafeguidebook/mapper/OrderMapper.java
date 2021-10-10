package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.domain.Order;
import com.flab.cafeguidebook.domain.OrderMenu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

  Long insertOrder(@Param("order") Order order);

  int insertOrderMenus(@Param("orderMenuList") List<OrderMenu> orderMenuList);
}
