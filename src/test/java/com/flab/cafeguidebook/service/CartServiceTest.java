package com.flab.cafeguidebook.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.flab.cafeguidebook.domain.CartItem;
import com.flab.cafeguidebook.dto.CartItemDTO;
import com.flab.cafeguidebook.fixture.CartItemDTOFixtureProvider;
import com.flab.cafeguidebook.fixture.CartItemFixtureProvider;
import com.flab.cafeguidebook.mapper.CartMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, CartItemFixtureProvider.class,
    CartItemDTOFixtureProvider.class})
@SpringBootTest
public class CartServiceTest {

  @Mock
  private CartMapper cartMapper;

  @InjectMocks
  private CartService cartService;

  @Test
  public void addCartItem(CartItemDTO cartItemDTO, CartItem cartItem) {
    when(cartMapper.insertCartItem(cartItemDTO.getUserId(), cartItem)).thenReturn(1);
    assertTrue(cartService.addCartItem(cartItemDTO.getUserId(), cartItemDTO));
  }
}
