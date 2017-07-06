package com.fingertalktalk.persistence;


import com.fingertalktalk.domain.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
@Mapper //스프링이 구동될 때 해당 인터페이스는 스프링 IOC 컨테이너에 인스턴스로 등록되게 된다.
public interface ApiMapper {

    //MemberMapper
    @Insert("INSERT INTO member(member_id, member_pw, member_name, member_phone " +
            "VALUES (#{member_id}, #{member_pw}, #{member_name}, #{member_phone})")

    @Select("SELECT member_id, member_pw, member_name, member_phone from member where member_id = #{id}")
    MemberVO getMemberInfo(String id);

/*    @Select("SELECT * from member")
    List<MemberVO> getMemberList();
*/
}