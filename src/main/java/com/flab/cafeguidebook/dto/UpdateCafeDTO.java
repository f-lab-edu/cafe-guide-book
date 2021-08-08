package com.flab.cafeguidebook.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class UpdateCafeDTO {

    @NonNull
    @NotBlank
    private String userId;

    @NonNull
    @NotBlank
    private String cafeId;

    @NonNull
    @NotBlank
    private String cafeName;

    private String tel;

    private String addressCode;

    private String addressDetail;

    private String operatingTime;

    private String cafeInfo;

    private String socialMedia;

    private LocalDateTime updateDate;

    private Boolean wifi;

    private Boolean reservation;

    private Boolean parkingSpace;

    private Boolean noKidsZone;

    private Boolean withPet;

    public static UpdateCafeDTO copyWithId(UpdateCafeDTO updateCafeDTO, String cafeId,
        String userId) {
        UpdateCafeDTO copyData = new UpdateCafeDTO();
        copyData.setUserId(userId);
        copyData.setCafeId(cafeId);
        copyData.setCafeName(updateCafeDTO.getCafeName());
        copyData.setTel(updateCafeDTO.getTel());
        copyData.setAddressCode(updateCafeDTO.getAddressCode());
        copyData.setAddressDetail(updateCafeDTO.getAddressDetail());
        copyData.setOperatingTime(updateCafeDTO.getOperatingTime());
        copyData.setCafeInfo(updateCafeDTO.getCafeInfo());
        copyData.setSocialMedia(updateCafeDTO.getSocialMedia());
        copyData.setUpdateDate(updateCafeDTO.getUpdateDate());
        copyData.setWifi(updateCafeDTO.getWifi());
        copyData.setReservation(updateCafeDTO.getReservation());
        copyData.setParkingSpace(updateCafeDTO.getParkingSpace());
        copyData.setNoKidsZone(updateCafeDTO.getNoKidsZone());
        copyData.setWithPet(updateCafeDTO.getWithPet());

        return copyData;
    }

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

    @NonNull
    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(@NonNull String cafeName) {
        this.cafeName = cafeName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UpdateCafeDTO)) {
            return false;
        }
        UpdateCafeDTO that = (UpdateCafeDTO) o;
        return getUserId().equals(that.getUserId()) && getCafeId().equals(that.getCafeId())
            && getCafeName().equals(that.getCafeName()) && Objects
            .equals(getTel(), that.getTel()) && Objects
            .equals(getAddressCode(), that.getAddressCode()) && Objects
            .equals(getAddressDetail(), that.getAddressDetail()) && Objects
            .equals(getOperatingTime(), that.getOperatingTime()) && Objects
            .equals(getCafeInfo(), that.getCafeInfo()) && Objects
            .equals(getSocialMedia(), that.getSocialMedia()) && Objects
            .equals(getUpdateDate(), that.getUpdateDate()) && Objects
            .equals(getWifi(), that.getWifi()) && Objects
            .equals(getReservation(), that.getReservation()) && Objects
            .equals(getParkingSpace(), that.getParkingSpace()) && Objects
            .equals(getNoKidsZone(), that.getNoKidsZone()) && Objects
            .equals(getWithPet(), that.getWithPet());
    }

    @Override
    public int hashCode() {
        return Objects
            .hash(getUserId(), getCafeId(), getCafeName(), getTel(),
                getAddressCode(),
                getAddressDetail(), getOperatingTime(), getCafeInfo(), getSocialMedia(),
                getUpdateDate(), getWifi(), getReservation(), getParkingSpace(), getNoKidsZone(),
                getWithPet());
    }

    @Override
    public String toString() {
        return "UpdateCafeDTO{" +
            "userId='" + userId + '\'' +
            ", cafeId='" + cafeId + '\'' +
            ", cafeName='" + cafeName + '\'' +
            ", tel='" + tel + '\'' +
            ", addressCode='" + addressCode + '\'' +
            ", addressDetail='" + addressDetail + '\'' +
            ", operatingTime='" + operatingTime + '\'' +
            ", cafeInfo='" + cafeInfo + '\'' +
            ", socialMedia='" + socialMedia + '\'' +
            ", updateDate=" + updateDate +
            ", wifi=" + wifi +
            ", reservation=" + reservation +
            ", parkingSpace=" + parkingSpace +
            ", noKidsZone=" + noKidsZone +
            ", withPet=" + withPet +
            '}';
    }
}
