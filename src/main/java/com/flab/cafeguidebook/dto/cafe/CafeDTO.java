package com.flab.cafeguidebook.dto.cafe;

import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.lang.NonNull;

public class CafeDTO {

    // 카페 영업 유무(오픈, 마감)
    public enum CafeCondition{
        OPEN, CLOSE
    }

    // 카페 등록 여부(대기, 반려, 승인)
    public enum CafeRegistration{
        PENDING, DENY, APPROVAL
    }

    // 외래키
    // 카페 주인 아이디
    @NonNull
    private String id;

    // 외래키
    // 해시태그 매핑 아이디
    private String hashTageId;

    // 카페 이름
    @NonNull
    private String cafeName;

    // 카페 사업자 등록번호
    private String bizNumber;

    // 전화번호
    private String tel;

    // 주소 코드
    private String addressCode;

    // 상세 주소
    private String addressDetail;

    // 영업 시간
    private String operatingTime;

    // 카페 소개
    private String cafeInfo;

    // sns 주소
    private String socialMedia;

    // 카페 등록일
    private LocalDateTime registrationDate;

    // 최종 수정일
    private LocalDateTime updateDate;

    // wifi 유무
    private Boolean wifi;

    // 예약 가능 여부
    private Boolean reservation;

    // 주차 공간 여부
    private Boolean parkingSpace;

    // 노키즈존 여부
    private Boolean noKidsZone;

    // 애견동반 여부
    private Boolean withPet;

    // 카페 영업 유무(오픈, 마감)
    private CafeCondition cafeCondition;

    // 카페 등록 여부(대기, 반려, 승인)
    private CafeRegistration cafeRegistration;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
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
        return getId().equals(cafeDTO.getId()) && Objects
            .equals(getHashTageId(), cafeDTO.getHashTageId()) && getCafeName()
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
            .hash(getId(), getHashTageId(), getCafeName(), getBizNumber(), getTel(),
                getAddressCode(),
                getAddressDetail(), getOperatingTime(), getCafeInfo(), getSocialMedia(),
                getRegistrationDate(), getUpdateDate(), getWifi(), getReservation(),
                getParkingSpace(),
                getNoKidsZone(), getWithPet(), getCafeCondition(), getCafeRegistration());
    }

    @Override
    public String toString() {
        return "CafeDTO{" +
            "id='" + id + '\'' +
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
