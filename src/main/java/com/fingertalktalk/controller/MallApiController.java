package com.fingertalktalk.controller;

import com.fingertalktalk.domain.MallVO;
import com.fingertalktalk.persistence.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by HYEYOON on 2017-07-07.
 * Mall 정보와 관련된 Controller
 */

@RestController
public class MallApiController {
    @Autowired
    private MallMapper mallMapper;

    //mall id와 일치하는 몰정보 데이턴
    @RequestMapping(method = RequestMethod.POST, value = "/getMallInfo")
    public MallVO getMallInfo(@RequestParam String mall_name) {
        return mallMapper.getMallInfo(mall_name);
    }

    //몰 리스트 데이터
    @RequestMapping(method = RequestMethod.GET, value = "getMallList")
    public List<MallVO> getMallList() {
        return mallMapper.getMallList();
    }
}
