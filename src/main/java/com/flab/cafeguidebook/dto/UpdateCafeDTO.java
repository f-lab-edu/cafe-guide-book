package com.flab.cafeguidebook.dto;

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

    private Boolean wifi;

    private Boolean reservation;

    private Boolean parkingSpace;

    private Boolean noKidsZone;

    private Boolean withPet;

    public UpdateCafeDTO() {
    }

    public UpdateCafeDTO(Builder builder) {
        this.userId = userId;
        this.cafeId = cafeId;
        this.cafeName = cafeName;
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

    public UpdateCafeDTO(@NonNull String userId, @NonNull String cafeId,
        @NonNull String cafeName, String tel, String addressCode, String addressDetail,
        String operatingTime, String cafeInfo, String socialMedia, Boolean wifi,
        Boolean reservation, Boolean parkingSpace, Boolean noKidsZone, Boolean withPet) {
        this.userId = userId;
        this.cafeId = cafeId;
        this.cafeName = cafeName;
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

    public static UpdateCafeDTO.Builder builder() {
        return new UpdateCafeDTO.Builder();
    }

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
        private String userId;
        private String cafeId;
        private String cafeName;
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

        public UpdateCafeDTO.Builder Builder() {
            return this;
        }

        public UpdateCafeDTO.Builder userId(@NonNull final String userId) {
            this.userId = userId;
            return this;
        }

        public UpdateCafeDTO.Builder cafeId(@NonNull final String cafeId) {
            this.cafeId = cafeId;
            return this;
        }

        public UpdateCafeDTO.Builder cafeName(@NonNull final String cafeName) {
            this.cafeName = cafeName;
            return this;
        }

        public UpdateCafeDTO.Builder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public UpdateCafeDTO.Builder addressCode(final String addressCode) {
            this.addressCode = addressCode;
            return this;
        }

        public UpdateCafeDTO.Builder addressDetail(final String addressDetail) {
            this.addressDetail = addressDetail;
            return this;
        }

        public UpdateCafeDTO.Builder operatingTime(final String operatingTime) {
            this.operatingTime = operatingTime;
            return this;
        }

        public UpdateCafeDTO.Builder cafeInfo(final String cafeInfo) {
            this.cafeInfo = cafeInfo;
            return this;
        }

        public UpdateCafeDTO.Builder socialMedia(final String socialMedia) {
            this.socialMedia = socialMedia;
            return this;
        }

        public UpdateCafeDTO.Builder wifi(final Boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public UpdateCafeDTO.Builder reservation(final Boolean reservation) {
            this.reservation = reservation;
            return this;
        }

        public UpdateCafeDTO.Builder parkingSpace(final Boolean parkingSpace) {
            this.parkingSpace = parkingSpace;
            return this;
        }

        public UpdateCafeDTO.Builder noKidsZone(final Boolean noKidsZone) {
            this.noKidsZone = noKidsZone;
            return this;
        }

        public UpdateCafeDTO.Builder withPet(final Boolean withPet) {
            this.withPet = withPet;
            return this;
        }

        public UpdateCafeDTO build() {
            return new UpdateCafeDTO(this.userId, this.cafeId, this.cafeName, this.tel, this.addressCode, this.addressDetail, this.operatingTime, this.cafeInfo, this.socialMedia, this.wifi, this.reservation, this.parkingSpace, this.noKidsZone, this.withPet);
        }

    }

}
