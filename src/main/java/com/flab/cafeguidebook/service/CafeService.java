package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.CafeDTO;
<<<<<<< HEAD
import com.flab.cafeguidebook.dto.UpdateCafeDTO;
=======
import com.flab.cafeguidebook.enumeration.CafeRegistration;
>>>>>>> develop
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

<<<<<<< HEAD
    public boolean addCafe(CafeDTO cafeDTO) {
        int insertCafe = cafeMapper.insertCafe(cafeDTO);
        return insertCafe == 1;
    }

    public List<CafeDTO> getMyAllCafe(String userId) {
        return cafeMapper.selectMyAllCafe(userId);
    }

    public boolean validateMyCafe(String cafeId, String userId) throws HttpClientErrorException{
        boolean isMyCafe = cafeMapper.isMyCafe(cafeId, userId);
        if (!isMyCafe) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
        return true;
    }

    public CafeDTO getMyCafe(String cafeId, String userId) {
        return cafeMapper.selectMyCafe(cafeId, userId);
    }

    public boolean updateCafe(UpdateCafeDTO updateCafeDTO) {
        int updateCafe = cafeMapper.updateCafe(updateCafeDTO);
        return updateCafe == 1;
    }
=======
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
>>>>>>> develop
}
