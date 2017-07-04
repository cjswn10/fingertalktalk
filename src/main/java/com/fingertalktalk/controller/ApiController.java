package com.fingertalktalk.controller;

import com.fingertalktalk.domain.LoginVO;
import com.fingertalktalk.persistence.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HYEYOON on 2017-07-04.
 */
@RestController
public class ApiController {
    @Autowired
    private ApiMapper apiMapper;

    @RequestMapping("/test")
    public String test() {return "Test";}
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public List<LoginVO> hello()
    {
        return apiMapper.getLogin();
    }

}
