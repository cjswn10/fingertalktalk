package com.fingertalktalk.persistence;

import com.fingertalktalk.domain.LoginVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ApiMapper {
    @Insert("INSERT INTO login(id, pw) VALUES (#{id}, #{pw})")
    int addLogin(LoginVO login);

    @Select("SELECT * from login")
    List<LoginVO> getLogin();
}

