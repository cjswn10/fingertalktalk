package com.fingertalktalk.persistence;

import com.fingertalktalk.domain.MallVO;
import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * from mall where mall_name = #{mall_name}")
    MallVO getMallInfo(@Param("mall_name") String mall_name);

    @Select("SELECT * from mall where mall_idx = #{mall_idx}")
    MallVO getMallInfoByIdx(@Param("mall_idx") int mall_idx);

    @Insert("INSERT into mall(mall_name, server_name, mall_img, auto_login_url, is_cafe24) values(#{mall_name}, #{server_name}, #{mall_img}, #{auto_login_url}, #{is_cafe24})")
    boolean addMallInfo(MallVO mallVO);

    @Update("UPDATE mall SET mall_name = #{mall_name}, server_name = #{server_name}, mall_img = #{mall_img}, auto_login_url = #{auto_login_url}, is_cafe24 = #{is_cafe24} WHERE mall_idx = #{mall_idx}")
    boolean updateMallInfo(MallVO mallVO);
}
