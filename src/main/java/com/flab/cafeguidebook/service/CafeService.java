package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.dto.UpdateCafeDTO;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CafeService {

  @Autowired
  private CafeMapper cafeMapper;

  public boolean addCafe(CafeDTO cafeDTO) {
    int insertCafe = cafeMapper.insertCafe(cafeDTO);
    return insertCafe == 1;
  }

  public boolean approveRegistration(Long cafeId) {
    return cafeMapper.updateRegistration(cafeId, CafeRegistration.APPROVAL) == 1;
  }

  public boolean denyRegistration(Long cafeId) {
    return cafeMapper.updateRegistration(cafeId, CafeRegistration.DENY) == 1;
  }

  public List<CafeDTO> getMyAllCafe(Long userId) {
    return cafeMapper.selectMyAllCafe(userId);
  }

  public boolean validateMyCafe(Long cafeId, Long userId) throws HttpClientErrorException{
    boolean isMyCafe = cafeMapper.isMyCafe(cafeId, userId);
    if (!isMyCafe) {
      throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
    }
    return true;
  }

  public CafeDTO getMyCafe(Long cafeId, Long userId) {
    return cafeMapper.selectMyCafe(cafeId, userId);
  }

  public boolean updateCafe(UpdateCafeDTO updateCafeDTO) {
    int updateCafe = cafeMapper.updateCafe(updateCafeDTO);
    return updateCafe == 1;
  }
}
