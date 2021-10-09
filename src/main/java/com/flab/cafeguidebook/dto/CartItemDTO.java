package com.flab.cafeguidebook.dto;

import java.util.List;

public class CartItemDTO {

  private Long id;

  private String name;

  private Long price;

  private Long cafeId;

  private Long menuId;

  private Long count;

  private Long userId;

  private List<CartOptionDTO> optionList;

  public CartItemDTO(CartItemDTO.Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.price = builder.price;
    this.cafeId = builder.cafeId;
    this.menuId = builder.menuId;
    this.count = builder.userId;
    this.userId = builder.userId;
    this.optionList = builder.optionList;
  }

  public CartItemDTO(Long id, String name, Long price, Long cafeId, Long menuId, Long count,
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

  public static CartItemDTO.Builder builder() {
    return new CartItemDTO.Builder();
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

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
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

  public static class Builder {

    private Long id;

    private String name;

    private Long price;

    private Long cafeId;

    private Long menuId;

    private Long count;

    private Long userId;

    private List<CartOptionDTO> optionList;


    public CartItemDTO.Builder Builder() {
      return this;
    }

    public CartItemDTO.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public CartItemDTO.Builder name(String name) {
      this.name = name;
      return this;
    }

    public CartItemDTO.Builder price(Long price) {
      this.price = price;
      return this;
    }

    public CartItemDTO.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public CartItemDTO.Builder menuId(Long menuId) {
      this.menuId = menuId;
      return this;
    }

    public CartItemDTO.Builder count(Long count) {
      this.count = count;
      return this;
    }

    public CartItemDTO.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public CartItemDTO.Builder optionList(List<CartOptionDTO> optionList) {
      this.optionList = optionList;
      return this;
    }

    public CartItemDTO build() {
      return new CartItemDTO(this);
    }
  }

}
