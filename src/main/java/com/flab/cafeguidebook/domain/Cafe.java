package com.flab.cafeguidebook.domain;

import com.flab.cafeguidebook.enumeration.CafeCondition;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import java.time.LocalDateTime;
import org.checkerframework.checker.nullness.qual.NonNull;

public class Cafe {

  private Long userId;
  private Long cafeId;
  private String hashTageId;
  private String cafeName;
  private String bizNumber;
  private String tel;
  private String addressCode;
  private String addressDetail;
  private String operatingTime;
  private String cafeInfo;
  private String socialMedia;
  private LocalDateTime registrationDate;
  private LocalDateTime updateDate;
  private Boolean wifi;
  private Boolean reservation;
  private Boolean parkingSpace;
  private Boolean noKidsZone;
  private Boolean withPet;
  private CafeCondition cafeCondition;
  private CafeRegistration cafeRegistration;

  public Cafe(Builder builder) {
    this.userId = builder.userId;
    this.cafeId = builder.cafeId;
    this.hashTageId = builder.hashTageId;
    this.cafeName = builder.cafeName;
    this.bizNumber = builder.bizNumber;
    this.tel = builder.tel;
    this.addressCode = builder.addressCode;
    this.addressDetail = builder.addressDetail;
    this.operatingTime = builder.operatingTime;
    this.cafeInfo = builder.cafeInfo;
    this.socialMedia = builder.socialMedia;
    this.registrationDate = builder.registrationDate;
    this.updateDate = builder.updateDate;
    this.wifi = builder.wifi;
    this.reservation = builder.reservation;
    this.parkingSpace = builder.parkingSpace;
    this.noKidsZone = builder.noKidsZone;
    this.withPet = builder.withPet;
    this.cafeCondition = builder.cafeCondition;
    this.cafeRegistration = builder.cafeRegistration;
  }

  public Cafe(Long userId, Long cafeId, String hashTageId, String cafeName,
      String bizNumber, String tel, String addressCode, String addressDetail,
      String operatingTime, String cafeInfo, String socialMedia,
      LocalDateTime registrationDate, LocalDateTime updateDate, Boolean wifi,
      Boolean reservation, Boolean parkingSpace, Boolean noKidsZone, Boolean withPet,
      CafeCondition cafeCondition,
      CafeRegistration cafeRegistration) {
    this.userId = userId;
    this.cafeId = cafeId;
    this.hashTageId = hashTageId;
    this.cafeName = cafeName;
    this.bizNumber = bizNumber;
    this.tel = tel;
    this.addressCode = addressCode;
    this.addressDetail = addressDetail;
    this.operatingTime = operatingTime;
    this.cafeInfo = cafeInfo;
    this.socialMedia = socialMedia;
    this.registrationDate = registrationDate;
    this.updateDate = updateDate;
    this.wifi = wifi;
    this.reservation = reservation;
    this.parkingSpace = parkingSpace;
    this.noKidsZone = noKidsZone;
    this.withPet = withPet;
    this.cafeCondition = cafeCondition;
    this.cafeRegistration = cafeRegistration;
  }

  public static Builder builder() {
    return new Builder();
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

  public String getHashTageId() {
    return hashTageId;
  }

  public void setHashTageId(String hashTageId) {
    this.hashTageId = hashTageId;
  }

  public String getCafeName() {
    return cafeName;
  }

  public void setCafeName(String cafeName) {
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

  public LocalDateTime getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(LocalDateTime registrationDate) {
    this.registrationDate = registrationDate;
  }

  public LocalDateTime getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDateTime updateDate) {
    this.updateDate = updateDate;
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

  public CafeCondition getCafeCondition() {
    return cafeCondition;
  }

  public void setCafeCondition(CafeCondition cafeCondition) {
    this.cafeCondition = cafeCondition;
  }

  public CafeRegistration getCafeRegistration() {
    return cafeRegistration;
  }

  public void setCafeRegistration(CafeRegistration cafeRegistration) {
    this.cafeRegistration = cafeRegistration;
  }

  public static class Builder {

    private Long userId;
    private Long cafeId;
    private String hashTageId;
    private String cafeName;
    private String bizNumber;
    private String tel;
    private String addressCode;
    private String addressDetail;
    private String operatingTime;
    private String cafeInfo;
    private String socialMedia;
    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;
    private Boolean wifi;
    private Boolean reservation;
    private Boolean parkingSpace;
    private Boolean noKidsZone;
    private Boolean withPet;
    private CafeCondition cafeCondition;
    private CafeRegistration cafeRegistration;

    public Cafe.Builder Builder() {
      return this;
    }

    public Cafe.Builder userId(final Long userId) {
      this.userId = userId;
      return this;
    }

    public Cafe.Builder cafeId(final Long cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public Cafe.Builder hashTageId(final String hashTageId) {
      this.hashTageId = hashTageId;
      return this;
    }

    public Cafe.Builder cafeName(final String cafeName) {
      this.cafeName = cafeName;
      return this;
    }

    public Cafe.Builder bizNumber(final String bizNumber) {
      this.bizNumber = bizNumber;
      return this;
    }

    public Cafe.Builder tel(final String tel) {
      this.tel = tel;
      return this;
    }

    public Cafe.Builder addressCode(final String addressCode) {
      this.addressCode = addressCode;
      return this;
    }

    public Cafe.Builder addressDetail(final String addressDetail) {
      this.addressDetail = addressDetail;
      return this;
    }

    public Cafe.Builder operatingTime(final String operatingTime) {
      this.operatingTime = operatingTime;
      return this;
    }

    public Cafe.Builder cafeInfo(final String cafeInfo) {
      this.cafeInfo = cafeInfo;
      return this;
    }

    public Cafe.Builder socialMedia(final String socialMedia) {
      this.socialMedia = socialMedia;
      return this;
    }

    public Cafe.Builder registrationDate(final LocalDateTime registrationDate) {
      this.registrationDate = registrationDate;
      return this;
    }

    public Cafe.Builder updateDate(final LocalDateTime updateDate) {
      this.updateDate = updateDate;
      return this;
    }

    public Cafe.Builder wifi(final Boolean wifi) {
      this.wifi = wifi;
      return this;
    }

    public Cafe.Builder reservation(final Boolean reservation) {
      this.reservation = reservation;
      return this;
    }

    public Cafe.Builder parkingSpace(final Boolean parkingSpace) {
      this.parkingSpace = parkingSpace;
      return this;
    }

    public Cafe.Builder noKidsZone(final Boolean noKidsZone) {
      this.noKidsZone = noKidsZone;
      return this;
    }

    public Cafe.Builder withPet(final Boolean withPet) {
      this.withPet = withPet;
      return this;
    }

    public Cafe.Builder cafeCondition(final CafeCondition cafeCondition) {
      this.cafeCondition = cafeCondition;
      return this;
    }

    public Cafe.Builder cafeRegistration(final CafeRegistration cafeRegistration) {
      this.cafeRegistration = cafeRegistration;
      return this;
    }

    public Cafe build() {
      return new Cafe(this.userId, this.cafeId, this.hashTageId, this.cafeName,
          this.bizNumber, this.tel, this.addressCode, this.addressDetail, this.operatingTime,
          this.cafeInfo, this.socialMedia, this.registrationDate, this.updateDate, this.wifi,
          this.reservation, this.parkingSpace, this.noKidsZone, this.withPet,
          this.cafeCondition, this.cafeRegistration);
    }
  }
}
