package com.flab.cafeguidebook.domain;

public class OrderMenu {

  private Long orderId;

  private Long menuId;

  private Long count;

  public OrderMenu(Long orderId, Long menuId, Long count) {
    this.orderId = orderId;
    this.menuId = menuId;
    this.count = count;
  }

  public OrderMenu(OrderMenu.Builder builder) {
    this.orderId = builder.orderId;
    this.menuId = builder.menuId;
    this.count = builder.count;
  }

  public static OrderMenu.Builder builder() {
    return new OrderMenu.Builder();
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
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

    private Long orderId;

    private Long menuId;

    private Long count;

    public OrderMenu.Builder Builder() {
      return this;
    }

    public OrderMenu.Builder orderId(Long orderId) {
      this.orderId = orderId;
      return this;
    }

    public OrderMenu.Builder menuId(Long menuId) {
      this.menuId = menuId;
      return this;
    }

    public OrderMenu.Builder count(Long count) {
      this.count = count;
      return this;
    }

    public OrderMenu build() {
      return new OrderMenu(this);
    }

  }
}
