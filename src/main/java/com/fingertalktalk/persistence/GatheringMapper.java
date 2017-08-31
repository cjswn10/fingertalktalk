package com.fingertalktalk.persistence;

import com.fingertalktalk.domain.GatheringVO;
//import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jungmini on 2017. 8. 16..
 * 모임 정보에 관련된 매퍼
 */
@Repository
@Mapper
public interface GatheringMapper {
    @Select("SELECT * from gathering")
    List<GatheringVO> getGatheringList();


}
