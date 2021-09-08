package com.flab.cafeguidebook.dto;

public class HeartDTO {

  private Long userId;

  private Long cafeId;

  public HeartDTO() {
  }

  public HeartDTO(HeartDTO.Builder builder) {
    this.userId = builder.userId;
    this.cafeId = builder.cafeId;
  }

  public HeartDTO(Long userId, Long cafeId) {
    this.userId = userId;
    this.cafeId = cafeId;
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

  public static class Builder {

    private Long userId;
    private Long cafeId;

    public HeartDTO.Builder Builder() {
      return this;
    }

    public HeartDTO.Builder userId(Long userId) {
      this.userId = userId;
      return this;
    }

    public HeartDTO.Builder cafeId(Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public HeartDTO build() {
      return new HeartDTO(this);
    }
  }
}
