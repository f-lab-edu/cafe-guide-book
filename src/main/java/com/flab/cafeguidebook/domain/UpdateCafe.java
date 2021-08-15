package com.flab.cafeguidebook.domain;

public class UpdateCafe {

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

    public UpdateCafe(Builder builder) {
        this.userId = builder.userId;
        this.cafeId = builder.cafeId;
        this.cafeName = builder.cafeName;
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

    public UpdateCafe(String userId, String cafeId, String cafeName, String tel,
        String addressCode, String addressDetail, String operatingTime, String cafeInfo,
        String socialMedia, Boolean wifi, Boolean reservation, Boolean parkingSpace,
        Boolean noKidsZone, Boolean withPet) {
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

    public static UpdateCafe.Builder builder() {
        return new UpdateCafe.Builder();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCafeId() {
        return cafeId;
    }

    public void setCafeId(String cafeId) {
        this.cafeId = cafeId;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
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

        public UpdateCafe.Builder Builder() {
            return this;
        }

        public UpdateCafe.Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public UpdateCafe.Builder cafeId(String cafeId) {
            this.cafeId = cafeId;
            return this;
        }

        public UpdateCafe.Builder cafeName(String cafeName) {
            this.cafeName = cafeName;
            return this;
        }

        public UpdateCafe.Builder tel(final String tel) {
            this.tel = tel;
            return this;
        }

        public UpdateCafe.Builder addressCode(final String addressCode) {
            this.addressCode = addressCode;
            return this;
        }

        public UpdateCafe.Builder addressDetail(final String addressDetail) {
            this.addressDetail = addressDetail;
            return this;
        }

        public UpdateCafe.Builder operatingTime(final String operatingTime) {
            this.operatingTime = operatingTime;
            return this;
        }

        public UpdateCafe.Builder cafeInfo(final String cafeInfo) {
            this.cafeInfo = cafeInfo;
            return this;
        }

        public UpdateCafe.Builder socialMedia(final String socialMedia) {
            this.socialMedia = socialMedia;
            return this;
        }

        public UpdateCafe.Builder wifi(final Boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public UpdateCafe.Builder reservation(final Boolean reservation) {
            this.reservation = reservation;
            return this;
        }

        public UpdateCafe.Builder parkingSpace(final Boolean parkingSpace) {
            this.parkingSpace = parkingSpace;
            return this;
        }

        public UpdateCafe.Builder noKidsZone(final Boolean noKidsZone) {
            this.noKidsZone = noKidsZone;
            return this;
        }

        public UpdateCafe.Builder withPet(final Boolean withPet) {
            this.withPet = withPet;
            return this;
        }

        public UpdateCafe build() {
            return new UpdateCafe(this.userId, this.cafeId, this.cafeName, this.tel,
                this.addressCode, this.addressDetail, this.operatingTime, this.cafeInfo,
                this.socialMedia, this.wifi, this.reservation, this.parkingSpace, this.noKidsZone,
                this.withPet);
        }

    }
}
