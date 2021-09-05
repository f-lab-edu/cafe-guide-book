package com.flab.cafeguidebook.domain;

import com.flab.cafeguidebook.enumeration.OptionStatus;

public class Option {

  private long optionId;
  private String optionName;
  private long menuId;
  private int optionPrice;
  private OptionStatus optionStatus;

  public Option(Builder builder) {
    this.optionId = optionId;
    this.optionName = optionName;
    this.menuId = menuId;
    this.optionPrice = optionPrice;
    this.optionStatus = optionStatus;
  }

  public Option(long optionId, String optionName, long menuId, int optionPrice,
      OptionStatus optionStatus) {
    this.optionName = optionName;
    this.menuId = menuId;
    this.optionPrice = optionPrice;
    this.optionStatus = optionStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  public long getOptionId() {
    return optionId;
  }

  public void setOptionId(long optionId) {
    this.optionId = optionId;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

  public int getOptionPrice() {
    return optionPrice;
  }

  public void setOptionPrice(int optionPrice) {
    this.optionPrice = optionPrice;
  }

  public OptionStatus getOptionStatus() {
    return optionStatus;
  }

  public void setOptionStatus(OptionStatus optionStatus) {
    this.optionStatus = optionStatus;
  }

  public static class Builder {

    private long optionId;
    private String optionName;
    private long menuId;
    private int optionPrice;
    private OptionStatus optionStatus;

    public Option.Builder Builder() {
      return this;
    }

    public Option.Builder optionId(final long optionId) {
      this.optionId = optionId;
      return this;
    }

    public Option.Builder optionName(final String optionName) {
      this.optionName = optionName;
      return this;
    }

    public Option.Builder menuName(final long menuId) {
      this.menuId = menuId;
      return this;
    }

    public Option.Builder optionPrice(final int optionPrice) {
      this.optionPrice = optionPrice;
      return this;
    }

    public Option.Builder optionStatus(final OptionStatus optionStatus) {
      this.optionStatus = optionStatus;
      return this;
    }

    public Option build() {
      return new Option(this.optionId, this.optionName, this.menuId, this.optionPrice,
          this.optionStatus);
    }
  }
}
