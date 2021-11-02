package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.HeartDTO;
import com.flab.cafeguidebook.mapper.HeartMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartService {

  @Autowired
  private HeartMapper heartMapper;

  public boolean addHeart(Long userId, Long cafeId) {
    return heartMapper.insertHeart(userId, cafeId) == 1;
  }

  public boolean removeHeart(Long userId, Long cafeId) {
    return heartMapper.deleteHeart(userId, cafeId) == 1;
  }

  public HeartDTO getHeart(Long userId, Long cafeId) {
    return heartMapper.selectHeart(userId, cafeId);
  }

  public List<HeartDTO> getUsersHearts(Long userId) {
    return heartMapper.selectUsersHearts(userId);
  }

//  public List<HeartDTO> getCafesHearts(Long cafeId) {
//    return heartMapper.selectCafesHearts(cafeId);
//  }
}
