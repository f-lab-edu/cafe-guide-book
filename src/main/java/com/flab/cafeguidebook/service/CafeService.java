package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import com.flab.cafeguidebook.mapper.CafeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

  public boolean deleteCafe(Long cafeId) {
    int deleteCafe = cafeMapper.deleteCafe(cafeId);
    return deleteCafe == 1;
  }
}
