package com.fingertalktalk.controller;

import com.fingertalktalk.domain.GatheringVO;
import com.fingertalktalk.domain.Result;
import com.fingertalktalk.persistence.GatheringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jungmini on 2017. 8. 16..
 */
@RestController
public class GatheringController {
    @Autowired
    private GatheringMapper gatheringMapper;
    private Result result = new Result();
    private Boolean gResult = false;


    @RequestMapping(method = RequestMethod.GET, value = "/getGatheringList")
    public List<GatheringVO> getGatheringList() {

        List<GatheringVO> gatheringList = gatheringMapper.getGatheringList();
        System.out.println(gatheringList);
        return gatheringMapper.getGatheringList();

    }

    // 새 모임 추가
    @RequestMapping(method = RequestMethod.POST, value = "/addGathering")
    public Result addGathering(@RequestBody GatheringVO newGathering) {
        System.out.println("Add New Gathering 진입");

        System.out.println(newGathering);
        if(newGathering.getGathering_title() == null || newGathering.getGathering_age_start() == null || newGathering.getGathering_age_end() == null || newGathering.getGathering_anonymity() == null || newGathering.getGathering_category() == null || newGathering.getGathering_character() == null ||newGathering.getGathering_date() == null) {
            System.out.println("addGathering 실패" + newGathering.toString());
            result.setCode("9999");
            result.setMsg("새 모임 등록 실패");

        } else {
            gatheringMapper.addGathering(newGathering);
            result.setCode("0000");
            result.setMsg("새 모임 등록 완료");
            result.setObj(newGathering);

        }

        return result;


    }
}
