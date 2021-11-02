package com.flab.cafeguidebook.domain;

import com.flab.cafeguidebook.dto.CartOptionDTO;
import java.util.List;

public class CartItem {

  private Long id;

  private String name;

  private Long price;

  private Long cafeId;

  private Long menuId;

  private Long count;

  private Long userId;
  private List<CartOptionDTO> optionList;

  public CartItem(CartItem.Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.price = builder.price;
    this.cafeId = builder.cafeId;
    this.menuId = builder.menuId;
    this.count = builder.userId;
    this.userId = builder.userId;
    this.optionList = builder.optionList;
  }

  public CartItem(Long id, String name, Long price, Long cafeId, Long menuId, Long count,
      Long userId, List<CartOptionDTO> optionList) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.cafeId = cafeId;
    this.menuId = menuId;
    this.count = count;
    this.userId = userId;
    this.optionList = optionList;
  }

  public static CartItem.Builder builder() {
    return new CartItem.Builder();
  }

  public Long getMenuId() {
    return menuId;
  }

  public void setMenuId(Long menuId) {
    this.menuId = menuId;
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Long getCafeId() {
    return cafeId;
  }

  public void setCafeId(Long cafeId) {
    this.cafeId = cafeId;
  }

  public List<CartOptionDTO> getOptionList() {
    return optionList;
  }

  public void setOptionList(List<CartOptionDTO> optionList) {
    this.optionList = optionList;
  }

  public static class Builder {

    private Long id;

    private String name;

    private Long price;

    private Long cafeId;

    private Long menuId;

    private Long count;

    private Long userId;

    private List<CartOptionDTO> optionList;


    public CartItem.Builder Builder() {
      return this;
    }

    public CartItem.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public CartItem.Builder name(String name) {
      this.name = name;
      return this;
    }

    public CartItem.Builder price(Long price) {
      this.price = price;
      return this;
    }

    public CartItem.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public CartItem.Builder menuId(Long menuId) {
      this.menuId = menuId;
      return this;
    }

    public CartItem.Builder count(Long count) {
      this.count = count;
      return this;
    }

    public CartItem.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public CartItem.Builder optionList(List<CartOptionDTO> optionList) {
      this.optionList = optionList;
      return this;
    }

    public CartItem build() {
      return new CartItem(this);
    }
  }
}
