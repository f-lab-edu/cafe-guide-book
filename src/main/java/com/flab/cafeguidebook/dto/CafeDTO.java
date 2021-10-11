package com.flab.cafeguidebook.dto;

import org.springframework.lang.NonNull;

public class CafeDTO {

  @NonNull
  private Long userId;

  @NonNull
  private Long cafeId;

  @NonNull
  private String cafeName;

  private String bizNumber;

  private String tel;

  private String addressCode;

  private String addressDetail;

  private String operatingTime;

  private String cafeInfo;

  private String socialMedia;

  private Boolean wifi;

  private Boolean reservation;

  private Boolean parkingSpace;

  private Boolean noKidsZone;

  private Boolean withPet;

  public CafeDTO() {
  }

  public CafeDTO(Builder builder) {
    this.userId = builder.userId;
    this.cafeId = builder.cafeId;
    this.cafeName = builder.cafeName;
    this.bizNumber = builder.bizNumber;
    this.tel = builder.tel;
    this.addressCode = builder.addressCode;
    this.addressDetail = builder.addressDetail;
    this.operatingTime = builder.operatingTime;
    this.cafeInfo = builder.cafeInfo;
    this.socialMedia = builder.socialMedia;
    this.wifi = builder.wifi;
    this.reservation = builder.reservation;
    this.parkingSpace = builder.parkingSpace;
    this.noKidsZone = builder.noKidsZone;
    this.withPet = builder.withPet;
  }

  public CafeDTO(@NonNull Long userId, @NonNull Long cafeId,
      @NonNull String cafeName, String bizNumber, String tel, String addressCode,
      String addressDetail, String operatingTime, String cafeInfo, String socialMedia,
      Boolean wifi,
      Boolean reservation, Boolean parkingSpace, Boolean noKidsZone, Boolean withPet) {
    this.userId = userId;
    this.cafeId = cafeId;
    this.cafeName = cafeName;
    this.bizNumber = bizNumber;
    this.tel = tel;
    this.addressCode = addressCode;
    this.addressDetail = addressDetail;
    this.operatingTime = operatingTime;
    this.cafeInfo = cafeInfo;
    this.socialMedia = socialMedia;
    this.wifi = wifi;
    this.reservation = reservation;
    this.parkingSpace = parkingSpace;
    this.noKidsZone = noKidsZone;
    this.withPet = withPet;
  }

  public static Builder builder() {
    return new Builder();
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

  @NonNull
  public String getCafeName() {
    return cafeName;
  }

  public void setCafeName(@NonNull String cafeName) {
    this.cafeName = cafeName;
  }

  public String getBizNumber() {
    return bizNumber;
  }

  public void setBizNumber(String bizNumber) {
    this.bizNumber = bizNumber;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getAddressCode() {
    return addressCode;
  }

  public void setAddressCode(String addressCode) {
    this.addressCode = addressCode;
  }

  public String getAddressDetail() {
    return addressDetail;
  }

  public void setAddressDetail(String addressDetail) {
    this.addressDetail = addressDetail;
  }

  public String getOperatingTime() {
    return operatingTime;
  }

  public void setOperatingTime(String operatingTime) {
    this.operatingTime = operatingTime;
  }

  public String getCafeInfo() {
    return cafeInfo;
  }

  public void setCafeInfo(String cafeInfo) {
    this.cafeInfo = cafeInfo;
  }

  public String getSocialMedia() {
    return socialMedia;
  }

  public void setSocialMedia(String socialMedia) {
    this.socialMedia = socialMedia;
  }

  public Boolean getWifi() {
    return wifi;
  }

  public void setWifi(Boolean wifi) {
    this.wifi = wifi;
  }

  public Boolean getReservation() {
    return reservation;
  }

  public void setReservation(Boolean reservation) {
    this.reservation = reservation;
  }

  public Boolean getParkingSpace() {
    return parkingSpace;
  }

  public void setParkingSpace(Boolean parkingSpace) {
    this.parkingSpace = parkingSpace;
  }

  public Boolean getNoKidsZone() {
    return noKidsZone;
  }

  public void setNoKidsZone(Boolean noKidsZone) {
    this.noKidsZone = noKidsZone;
  }

  public Boolean getWithPet() {
    return withPet;
  }

  public void setWithPet(Boolean withPet) {
    this.withPet = withPet;
  }


  public static class Builder {

    private Long userId;
    private Long cafeId;
    private String cafeName;
    private String bizNumber;
    private String tel;
    private String addressCode;
    private String addressDetail;
    private String operatingTime;
    private String cafeInfo;
    private String socialMedia;
    private Boolean wifi;
    private Boolean reservation;
    private Boolean parkingSpace;
    private Boolean noKidsZone;
    private Boolean withPet;

    public Builder Builder() {
      return this;
    }

    public CafeDTO.Builder userId(@NonNull final Long userId) {
      this.userId = userId;
      return this;
    }

    public CafeDTO.Builder cafeId(@NonNull final Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public CafeDTO.Builder cafeName(@NonNull final String cafeName) {
      this.cafeName = cafeName;
      return this;
    }

    public CafeDTO.Builder bizNumber(final String bizNumber) {
      this.bizNumber = bizNumber;
      return this;
    }

    public CafeDTO.Builder tel(final String tel) {
      this.tel = tel;
      return this;
    }

    public CafeDTO.Builder addressCode(final String addressCode) {
      this.addressCode = addressCode;
      return this;
    }

    public CafeDTO.Builder addressDetail(final String addressDetail) {
      this.addressDetail = addressDetail;
      return this;
    }

    public CafeDTO.Builder operatingTime(final String operatingTime) {
      this.operatingTime = operatingTime;
      return this;
    }

    public CafeDTO.Builder cafeInfo(final String cafeInfo) {
      this.cafeInfo = cafeInfo;
      return this;
    }

    public CafeDTO.Builder socialMedia(final String socialMedia) {
      this.socialMedia = socialMedia;
      return this;
    }

    public CafeDTO.Builder wifi(final Boolean wifi) {
      this.wifi = wifi;
      return this;
    }

    public CafeDTO.Builder reservation(final Boolean reservation) {
      this.reservation = reservation;
      return this;
    }

    public CafeDTO.Builder parkingSpace(final Boolean parkingSpace) {
      this.parkingSpace = parkingSpace;
      return this;
    }

    public CafeDTO.Builder noKidsZone(final Boolean noKidsZone) {
      this.noKidsZone = noKidsZone;
      return this;
    }

    public CafeDTO.Builder withPet(final Boolean withPet) {
      this.withPet = withPet;
      return this;
    }

    public CafeDTO build() {
      return new CafeDTO(this.userId, this.cafeId, this.cafeName,
          this.bizNumber, this.tel, this.addressCode, this.addressDetail, this.operatingTime,
          this.cafeInfo, this.socialMedia, this.wifi,
          this.reservation, this.parkingSpace, this.noKidsZone, this.withPet);
    }
  }
}
