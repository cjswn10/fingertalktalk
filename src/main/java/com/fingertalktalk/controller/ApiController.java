package com.fingertalktalk.controller;

import com.fingertalktalk.domain.MemberVO;
import com.fingertalktalk.domain.Result;
import com.fingertalktalk.persistence.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//MemberController
@RestController
public class ApiController {
    @Autowired
    private ApiMapper apiMapper;
    /*@ReqeustBody 와 @ReqeustParam, @RequestAttribute 에 대해 공부하자*/

    //member_id를 이용해 회원정보 가져오기
    @RequestMapping(method = RequestMethod.POST, value = "/getMemberInfo")
    public MemberVO getMemberInfo(@RequestParam("member_id") String member_id) {
        System.out.println(member_id);
        System.out.println(apiMapper.getMemberInfo(member_id));
        return apiMapper.getMemberInfo(member_id);
    }

    //회원가입
    @RequestMapping(method = RequestMethod.POST, value = "/addMember")
    public Result addMemberInfo(@RequestBody MemberVO member) {
        Boolean validation = checkId(member);
        Result result = new Result();

        if (validation) {
            Boolean join = apiMapper.addMemberInfo(member);
            if (join) {
                result.setCode("0000");
                result.setMsg(member.getMember_name() + "님 회원가입 되었습니다.");
                result.setObj(member);
            } else {
                result.setCode("9999");
                result.setMsg("회원가입에 실패하였습니다");
            }
        } else {
            result.setCode("9999");
            result.setMsg("중복된 아이디입니다");
        }
        return result;
    }

    //ID 중복 확인
    @RequestMapping(method = RequestMethod.POST, value = "/checkId")
    public Boolean checkId(@RequestBody MemberVO member) {
        //가입가능
        if(apiMapper.getMemberInfo(member.getMember_id()) == null)
            return true;

        //가입불가
        else
            return false;
    }

    //id와 비밀번호 일치여부
    @RequestMapping(method = RequestMethod.POST, value = "/validateMember")
    public Result validateMember(@RequestBody MemberVO member) {
        System.out.println("validate : " + member);
        MemberVO origin = apiMapper.getMemberInfo(member.getMember_id());
        Result result = new Result();
        if(origin == null) {
            result.setCode("9999");
            result.setMsg("존재하지 않는 아이디입니다.");
        }
        else if (!origin.getMember_pw().equals(member.getMember_pw())) {
            result.setCode("9999");
            result.setMsg("비밀번호가 일치하지 않습니다.");
        }
        else {
            result.setCode("0000");
            result.setObj(member);
        }
        return result;
    }

    //회원정보 수정
    @RequestMapping(method = RequestMethod.POST, value = "/changeMemberInfo")
    public String changeMemberInfo(@RequestBody MemberVO member) {
        MemberVO origin = apiMapper.getMemberInfo(member.getMember_id());
        if(member.getMember_pw() == null)
            member.setMember_pw(origin.getMember_pw());
        if(member.getMember_name() == null)
            member.setMember_name(origin.getMember_name());
        if(member.getMember_phone() == null)
            member.setMember_phone(origin.getMember_phone());
        if(member.getMember_dep() == null)
            member.setMember_dep(origin.getMember_dep());

        Boolean result = apiMapper.changeMemberInfo(member);
        if(result)
            return "회원정보가 수정되었습니다.";
        else
            return "회원정보가 수정되지 않았습니다.";
    }
}