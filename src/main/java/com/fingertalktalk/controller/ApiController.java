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
    public MemberVO getMemberInfo(@RequestParam String id) {
        System.out.println(id);
        System.out.println(apiMapper.getMemberInfo(id));
        return apiMapper.getMemberInfo(id);
    }

/*    public List<MemberVO> getMemberList() {
        return apiMapper.getMemberList();
    }
*/

}