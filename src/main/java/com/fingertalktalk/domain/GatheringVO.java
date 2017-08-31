package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by jungmini on 2017. 8. 16..
 */
@Data
public class GatheringVO {
    int gathering_id;
    String gathering_title;
    String gathering_host;
    String gathering_character;
    String gathering_date;
    String gathering_anonymity;
    String gathering_category;
    String gathering_age_start;
    String gathering_age_end;

}
