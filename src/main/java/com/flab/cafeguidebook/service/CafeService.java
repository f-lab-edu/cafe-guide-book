package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.cafe.CafeDTO;
import com.flab.cafeguidebook.mapper.CafeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {

    @Autowired
    private CafeMapper cafeMapper;

    public void addCafe(CafeDTO cafeDTO) {
        int insertCafe = cafeMapper.insertCafe(cafeDTO);
    }

    public List<CafeDTO> myAllCafe(String id) {
        return cafeMapper.selectMyAllCafe(id);
    }
}

