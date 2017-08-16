package com.fingertalktalk.controller;

import com.fingertalktalk.domain.GatheringVO;
import com.fingertalktalk.persistence.GatheringMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(method = RequestMethod.GET, value = "/getGatheringList")
    public List<GatheringVO> getGatheringList() {

        List<GatheringVO> gatheringList = gatheringMapper.getGatheringList();
        System.out.println(gatheringList);
        return gatheringMapper.getGatheringList();


    }
}
