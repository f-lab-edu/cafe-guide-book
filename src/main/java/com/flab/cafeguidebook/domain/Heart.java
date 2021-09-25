package com.flab.cafeguidebook.domain;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class Heart {

  @NonNull
  @NotBlank
  private Long userId;

  @NonNull
  @NotBlank
  private Long cafeId;

  public Heart() {
  }

  public Heart(Heart.Builder builder) {
    this.userId = builder.userId;
    this.cafeId = builder.cafeId;
  }

  public Heart(@NonNull Long userId, @NonNull Long cafeId) {
    this.userId = userId;
    this.cafeId = cafeId;
  }


  @NonNull
  public Long getUserId() {
    return userId;
  }

  public void setUserId(@NonNull Long userId) {
    this.userId = userId;
  }

  @NonNull
  public Long getCafeId() {
    return cafeId;
  }

  public void setCafeId(@NonNull Long cafeId) {
    this.cafeId = cafeId;
  }

  public static class Builder {

    private Long userId;
    private Long cafeId;

    public Heart.Builder Builder() {
      return this;
    }

    public Heart.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public Heart.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public Heart build() {
      return new Heart(this);
    }
  }
}
