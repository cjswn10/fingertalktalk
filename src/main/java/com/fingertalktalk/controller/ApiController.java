package com.fingertalktalk.controller;

import com.fingertalktalk.domain.MemberVO;
import com.fingertalktalk.persistence.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {
    @Autowired
    private ApiMapper apiMapper;

    //MemberController
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public MemberVO getMemberInfo(String id) {
        return apiMapper.getMemberInfo(id);
    }

/*    public List<MemberVO> getMemberList() {
        return apiMapper.getMemberList();
    }
*/

}