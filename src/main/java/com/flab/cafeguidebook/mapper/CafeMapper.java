package com.flab.cafeguidebook.mapper;

import com.flab.cafeguidebook.annotation.DataSource;
import com.flab.cafeguidebook.annotation.DataSource.DataSourceType;
import com.flab.cafeguidebook.domain.Cafe;
import com.flab.cafeguidebook.dto.CafeDTO;
import com.flab.cafeguidebook.enumeration.CafeRegistration;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CafeMapper {

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int insertCafe(Cafe cafe);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public List<CafeDTO> selectMyAllCafe(long userId);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public boolean isMyCafe(@Param("cafeId") long cafeId, @Param("userId") long userId);

  @DataSource(dataSourceType = DataSourceType.SLAVE)
  public CafeDTO selectMyCafe(@Param("cafeId") long cafeId, @Param("userId") long userId);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public void deleteAllCafe();

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int updateCafe(Cafe cafe);

  @DataSource(dataSourceType = DataSourceType.MASTER)
  public int updateRegistration(@Param("id") Long id,
      @Param("registration") CafeRegistration registration);

}
