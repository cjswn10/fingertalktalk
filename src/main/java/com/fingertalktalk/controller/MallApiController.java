package com.fingertalktalk.controller;

import com.fingertalktalk.domain.MallVO;
import com.fingertalktalk.domain.Result;
import com.fingertalktalk.persistence.MallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MallVO getMallInfo(@RequestParam("mall_name") String mall_name) {
        System.out.println(mall_name);
        return mallMapper.getMallInfo(mall_name);
    }

    //몰 리스트 데이터
    @RequestMapping(method = RequestMethod.GET, value = "/getMallList")
    public List<MallVO> getMallList() {
        return mallMapper.getMallList();
    }

    //몰 정보 추가
    @RequestMapping(method = RequestMethod.POST, value = "/addMallInfo")
    public Result addMallInfo(@RequestBody MallVO mallVO) {
        Result result = new Result();
        boolean bResult = mallMapper.addMallInfo(mallVO);
        if(bResult) {
            result.setCode("0000");
            result.setMsg(mallVO.getMall_name() + " 몰이 새로 등록 되었습니다.");
        } else {
            System.out.println("addMallInfo 실패 " + mallVO.toString());
            result.setCode("9999");
            result.setMsg("몰 추가 실패");
        }
        return result;
    }

}
