package com.fingertalktalk.persistence;


import com.fingertalktalk.domain.MemberVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 *member 관련 맵퍼
 */
@Repository
@Mapper //스프링이 구동될 때 해당 인터페이스는 스프링 IOC 컨테이너에 인스턴스로 등록되게 된다.
public interface ApiMapper {
    //회원가입
    @Insert("INSERT INTO member(member_id, member_pw, member_name, member_phone)" +
            "VALUES (#{member_id}, #{member_pw}, #{member_name}, #{member_phone})")
    boolean addMemberInfo(MemberVO member);

    //ID로 회원정보 가져오기
    /*@Param 안의 "member_id" 는 Controller 에서 Mapper 를 호출할때 넣어주는 파라미터와 이름이 동일해야함*/
    @Select("SELECT member_id, member_pw, member_name, member_phone from member where member_id = #{member_id}")
    MemberVO getMemberInfo(@Param("member_id") String member_id);

    //회원정보 수정
    @Update("UPDATE member SET member_pw = #{member_pw}, member_name = #{member_name}," +
            " member_phone = #{member_phone} where member_id = #{member_id}")
    boolean changeMemberInfo(MemberVO member);

}