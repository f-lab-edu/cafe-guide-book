package com.flab.cafeguidebook.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class CafeDTO {

    public enum CafeCondition {
        OPEN, CLOSE
    }

    public enum CafeRegistration {
        PENDING, DENY, APPROVAL
    }

    @NonNull
    @NotBlank
    private String userId;

    @NonNull
    @NotBlank
    private String cafeId;

    private String hashTageId;

    @NonNull
    @NotBlank
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

    @NonNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NonNull String userId) {
        this.userId = userId;
    }

    @NonNull
    public String getCafeId() {
        return cafeId;
    }

    public void setCafeId(@NonNull String cafeId) {
        this.cafeId = cafeId;
    }

    public String getHashTageId() {
        return hashTageId;
    }

    public void setHashTageId(String hashTageId) {
        this.hashTageId = hashTageId;
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

    public void setCafeRegistration(
        CafeRegistration cafeRegistration) {
        this.cafeRegistration = cafeRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CafeDTO)) {
            return false;
        }
        CafeDTO cafeDTO = (CafeDTO) o;
        return getUserId().equals(cafeDTO.getUserId()) && getCafeId().equals(cafeDTO.getCafeId())
            && Objects.equals(getHashTageId(), cafeDTO.getHashTageId()) && getCafeName()
            .equals(cafeDTO.getCafeName()) && Objects
            .equals(getBizNumber(), cafeDTO.getBizNumber()) && Objects
            .equals(getTel(), cafeDTO.getTel()) && Objects
            .equals(getAddressCode(), cafeDTO.getAddressCode()) && Objects
            .equals(getAddressDetail(), cafeDTO.getAddressDetail()) && Objects
            .equals(getOperatingTime(), cafeDTO.getOperatingTime()) && Objects
            .equals(getCafeInfo(), cafeDTO.getCafeInfo()) && Objects
            .equals(getSocialMedia(), cafeDTO.getSocialMedia()) && Objects
            .equals(getRegistrationDate(), cafeDTO.getRegistrationDate()) && Objects
            .equals(getUpdateDate(), cafeDTO.getUpdateDate()) && Objects
            .equals(getWifi(), cafeDTO.getWifi()) && Objects
            .equals(getReservation(), cafeDTO.getReservation()) && Objects
            .equals(getParkingSpace(), cafeDTO.getParkingSpace()) && Objects
            .equals(getNoKidsZone(), cafeDTO.getNoKidsZone()) && Objects
            .equals(getWithPet(), cafeDTO.getWithPet()) && getCafeCondition() == cafeDTO
            .getCafeCondition() && getCafeRegistration() == cafeDTO.getCafeRegistration();
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(getUserId(), getCafeId(), getHashTageId(), getCafeName(), getBizNumber(),
                getTel(),
                getAddressCode(), getAddressDetail(), getOperatingTime(), getCafeInfo(),
                getSocialMedia(), getRegistrationDate(), getUpdateDate(), getWifi(),
                getReservation(),
                getParkingSpace(), getNoKidsZone(), getWithPet(), getCafeCondition(),
                getCafeRegistration());
    }

    @Override
    public String toString() {
        return "CafeDTO{" +
            "userId='" + userId + '\'' +
            ", cafeId='" + cafeId + '\'' +
            ", hashTageId='" + hashTageId + '\'' +
            ", cafeName='" + cafeName + '\'' +
            ", bizNumber='" + bizNumber + '\'' +
            ", tel='" + tel + '\'' +
            ", addressCode='" + addressCode + '\'' +
            ", addressDetail='" + addressDetail + '\'' +
            ", operatingTime='" + operatingTime + '\'' +
            ", cafeInfo='" + cafeInfo + '\'' +
            ", socialMedia='" + socialMedia + '\'' +
            ", registrationDate=" + registrationDate +
            ", updateDate=" + updateDate +
            ", wifi=" + wifi +
            ", reservation=" + reservation +
            ", parkingSpace=" + parkingSpace +
            ", noKidsZone=" + noKidsZone +
            ", withPet=" + withPet +
            ", cafeCondition=" + cafeCondition +
            ", cafeRegistration=" + cafeRegistration +
            '}';
    }
}


