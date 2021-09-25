package com.flab.cafeguidebook.service;

import com.flab.cafeguidebook.converter.OptionConverter.OptionDTOToOptionConverter;
import com.flab.cafeguidebook.dto.OptionDTO;
import com.flab.cafeguidebook.mapper.OptionMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

  @Autowired
  private OptionDTOToOptionConverter optionDTOToOptionConverter;

  @Autowired
  private OptionMapper optionMapper;

  public boolean addOption(OptionDTO optionDTO) {
    int insertOption = optionMapper.insertOption(optionDTOToOptionConverter.convert(optionDTO));
    return insertOption == 1;
  }

  public boolean updateOption(OptionDTO optionDTO) {
    int updateOption = optionMapper.updateOption(optionDTOToOptionConverter.convert(optionDTO));
    return updateOption == 1;
  }

  public List<OptionDTO> getAllOption(long menuId) {
    List<OptionDTO> selectAllOption = optionMapper.selectAllOption(menuId);
    return selectAllOption;
  }
}
