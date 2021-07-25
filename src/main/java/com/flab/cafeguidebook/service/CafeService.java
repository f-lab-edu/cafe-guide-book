package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
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

    public void addCafe(CafeDTO cafeDTO) {
        int insertCafe = cafeMapper.insertCafe(cafeDTO);
    }

    public List<CafeDTO> getMyAllCafe(String id) {
        return cafeMapper.selectMyAllCafe(id);
    }

    public void validateMyCafe(String cafeId, String id) throws HttpClientErrorException{
        boolean isMyCafe = cafeMapper.isMyCafe(cafeId, id);
        if (!isMyCafe) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }

    public CafeDTO getMyCafe(String cafeId, String id) {
        return cafeMapper.selectMyCafe(cafeId, id);
    }
}

