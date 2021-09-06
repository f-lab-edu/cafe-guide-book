package com.flab.cafeguidebook.dto;

import com.flab.cafeguidebook.enumeration.OptionStatus;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class OptionDTO {

  private long optionId;

  @NonNull
  @NotBlank
  private String optionName;

  @NonNull
  private long menuId;

  @NonNull
  private int optionPrice;

  private OptionStatus optionStatus;

  public OptionDTO() {

  }

  public OptionDTO(Builder builder) {
    this.optionName = optionName;
    this.menuId = menuId;
    this.optionPrice = optionPrice;
    this.optionStatus = optionStatus;
  }

  public OptionDTO(@NonNull long optionId, @NonNull String optionName, @NonNull long menuId,
      int optionPrice,
      OptionStatus optionStatus) {
    this.optionId = optionId;
    this.optionName = optionName;
    this.menuId = menuId;
    this.optionPrice = optionPrice;
    this.optionStatus = optionStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  @NonNull
  public long getOptionId() {
    return optionId;
  }

  public void setOptionId(@NonNull long optionId) {
    this.optionId = optionId;
  }

  @NonNull
  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(@NonNull String optionName) {
    this.optionName = optionName;
  }

  @NonNull
  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(@NonNull long menuId) {
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

    public Builder Builder() {
      return this;
    }

    public OptionDTO.Builder optionId(final long optionId) {
      this.optionId = optionId;
      return this;
    }

    public OptionDTO.Builder optionName(final String optionName) {
      this.optionName = optionName;
      return this;
    }

    public OptionDTO.Builder menuId(final long menuId) {
      this.menuId = menuId;
      return this;
    }

    public OptionDTO.Builder optionPrice(final int optionPrice) {
      this.optionPrice = optionPrice;
      return this;
    }

    public OptionDTO.Builder optionStatus(final OptionStatus optionStatus) {
      this.optionStatus = optionStatus;
      return this;
    }

    public OptionDTO build() {
      return new OptionDTO(this.optionId, this.optionName, this.menuId, this.optionPrice,
          this.optionStatus);
    }
  }
}
