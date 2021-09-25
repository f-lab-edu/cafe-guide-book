package com.flab.cafeguidebook.converter;

import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.dto.CafeDTO;
import org.springframework.stereotype.Component;

public class CafeConverter {


  @Component
  public static class CafeDTOToCafeConverter {

    public Cafe convert(CafeDTO cafeDTO) {
      Cafe cafe = new Cafe(cafeDTO.getUserId(), cafeDTO.getCafeId(), cafeDTO.getCafeName(),
          cafeDTO.getBizNumber(), cafeDTO.getTel(), cafeDTO.getAddressCode(),
          cafeDTO.getAddressDetail(), cafeDTO.getOperatingTime(), cafeDTO.getCafeInfo(),
          cafeDTO.getSocialMedia(), cafeDTO.getWifi(), cafeDTO.getReservation(),
          cafeDTO.getParkingSpace(), cafeDTO.getNoKidsZone(), cafeDTO.getWithPet());
      return cafe;
    }
  }

  @Component
  public static class CafeToCafeDTOConverter {

    public CafeDTO convert(Cafe cafe) {
      CafeDTO cafeDTO = new CafeDTO(cafe.getUserId(), cafe.getCafeId(), cafe.getCafeName(),
          cafe.getBizNumber(), cafe.getTel(), cafe.getAddressCode(),
          cafe.getAddressDetail(), cafe.getOperatingTime(), cafe.getCafeInfo(),
          cafe.getSocialMedia(), cafe.getWifi(), cafe.getReservation(),
          cafe.getParkingSpace(), cafe.getNoKidsZone(), cafe.getWithPet());
      return cafeDTO;

    }
  }
}
