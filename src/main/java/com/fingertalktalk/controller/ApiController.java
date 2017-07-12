package com.fingertalktalk.controller;

import com.fingertalktalk.domain.MemberVO;
import com.fingertalktalk.persistence.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiController {
    @Autowired
    private ApiMapper apiMapper;

    //MemberController
    //@ReqeustBody 와 @ReqeustParam, @RequestAttribute 에 대해 공부하자
    @RequestMapping(method = RequestMethod.POST, value = "/getMemberInfo")
    public MemberVO getMemberInfo(@RequestParam("member_id") String member_id) {
        System.out.println(member_id);
        System.out.println(apiMapper.getMemberInfo(member_id));
        return apiMapper.getMemberInfo(member_id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMemberInfo")
    public String addMemberInfo(@RequestBody MemberVO member) {
        Boolean result = apiMapper.addMemberInfo(member);
        if(result)
            return member.getMember_name() + "님 회원가입되었습니다.";
        else
            return "회원가입에 실패했습니다.";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/changeMemberInfo")
    public String changeMemberInfo(@RequestBody MemberVO member) {
        MemberVO origin = apiMapper.getMemberInfo(member.getMember_id());
        if(member.getMember_pw() == null)
            member.setMember_pw(origin.getMember_pw());
        if(member.getMember_name() == null)
            member.setMember_name(origin.getMember_name());
        if(member.getMember_phone() == null)
            member.setMember_phone(origin.getMember_phone());

        Boolean result = apiMapper.changeMemberInfo(member);
        if(result)
            return "회원정보가 수정되었습니다.";
        else
            return "회원정보가 수정되지 않았습니다.";
    }}