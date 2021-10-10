package com.flab.cafeguidebook.dto;

public class OrderDTO {

  private Long id;
  private Long userId;
  private Long cafeId;
  private String address;
  private Long totalPrice;

  public OrderDTO(Long id, Long userId, Long cafeId, String address, Long totalPrice) {
    this.id = id;
    this.userId = userId;
    this.cafeId = cafeId;
    this.address = address;
    this.totalPrice = totalPrice;
  }

  public OrderDTO(OrderDTO.Builder builder) {
    this.id = builder.id;
    this.userId = builder.userId;
    this.cafeId = builder.cafeId;
    this.address = builder.address;
    this.totalPrice = builder.totalPrice;
  }

  public static OrderDTO.Builder builder() {
    return new OrderDTO.Builder();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCafeId() {
    return cafeId;
  }

  public void setCafeId(Long cafeId) {
    this.cafeId = cafeId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Long totalPrice) {
    this.totalPrice = totalPrice;
  }

  public static class Builder {

    private Long id;
    private Long userId;
    private Long cafeId;
    private String address;
    private Long totalPrice;

    public OrderDTO.Builder Builder() {
      return this;
    }

    public OrderDTO.Builder id(Long id) {
      this.id = id;
      return this;
    }

    public OrderDTO.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public OrderDTO.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public OrderDTO.Builder address(String address) {
      this.address = address;
      return this;
    }

    public OrderDTO.Builder totalPrice(Long totalPrice) {
      this.totalPrice = totalPrice;
      return this;
    }

    public OrderDTO build() {
      return new OrderDTO(this);
    }

  }
}
