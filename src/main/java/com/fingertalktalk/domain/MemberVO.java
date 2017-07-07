package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by YJ on 2017-07-06.
 * 변수명은 DB의 칼럼명과 일치 시킬 것
 */
@Data
public class MemberVO {
    private String member_id;
    private String member_pw;
    private String member_name;
    private int member_phone;
}
