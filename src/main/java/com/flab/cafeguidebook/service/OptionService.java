package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.mapper.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

  @Autowired
  private OptionMapper optionMapper;

  public boolean addOption(OptionDTO optionDTO) {
    int insertOption = optionMapper.insertOption(optionDTO);
    return insertOption == 1;
  }

  public boolean updateOption(OptionDTO optionDTO) {
    int updateOption = optionMapper.updateOption(optionDTO);
    return updateOption == 1;
  }
}
