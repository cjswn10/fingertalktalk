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

    private Result result = new Result();
    private Boolean bResult = false;


    //mall id와 일치하는 몰정보 데이턴
    @RequestMapping(method = RequestMethod.POST, value = "/getMallInfo")
    public MallVO getMallInfo(@RequestParam("mall_name") String mall_name) {
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
        bResult = mallMapper.addMallInfo(mallVO);

        if(bResult) {
            result.setCode("0000");
            result.setMsg(mallVO.getMall_name() + " 몰이 새로 등록 되었습니다.");
            result.setObj(mallVO);
        } else {
            System.out.println("addMallInfo 실패 " + mallVO.toString());
            result.setCode("9999");
            result.setMsg("몰정보 추가 실패");
        }

        return result;
    }

    //몰 정보 업데이트
    @RequestMapping(method = RequestMethod.POST, value = "/changeMallInfo")
    public Result updateMallInfo(@RequestBody MallVO mallVO) {
        mallVO = checkMallInfo(mallVO);
        bResult = mallMapper.updateMallInfo(mallVO);

        if(bResult) {
            result.setCode("0000");
            result.setMsg(mallVO.getMall_name() + "몰정보 업데이트 완료");
            result.setObj(mallVO);
        }
        else {
            System.out.println("updateMallInfo 실패 " + mallVO.toString());
            result.setCode("9999");
            result.setMsg("몰정보 업데이트 실패");
        }

        return result;
    }

    //null 값일 경우 기존의 값으로 채워줌
    private MallVO checkMallInfo(MallVO mallVO) {
        MallVO recentMallInfo = mallMapper.getMallInfoByIdx(mallVO.getMall_idx());
        if(mallVO.getMall_name() == null)  {
            mallVO.setMall_name(recentMallInfo.getMall_name());
        }
        if(mallVO.getServer_name() == null) {
            mallVO.setServer_name(recentMallInfo.getServer_name());
        }
        if(mallVO.getMall_img() == null) {
            mallVO.setMall_img(recentMallInfo.getMall_img());
        }
        if(mallVO.getAuto_login_url() == null) {
            mallVO.setAuto_login_url(recentMallInfo.getAuto_login_url());
        }
        if(mallVO.getIs_cafe24() == null) {
            mallVO.setIs_cafe24(recentMallInfo.getIs_cafe24());
        }
        return mallVO;
    }
}
