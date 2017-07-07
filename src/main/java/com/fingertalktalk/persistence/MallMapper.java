package com.fingertalktalk.persistence;

import com.fingertalktalk.domain.MallVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HYEYOON on 2017-07-07.
 * Mall 정보에 관련된 맵퍼
 */
@Repository
@Mapper
public interface MallMapper {
    @Select("SELECT * from mall")
    List<MallVO> getMallList();

    @Select("SELECT * from mall where mall_name = {#mall_name}")
    MallVO getMallInfo(@Param("mall_name") String mall_name);
}
