package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by YJ on 2017-07-06.
 * 변수명과 순서를 DB의 칼럼과 일치 시킬 것
 */
@Data
public class MemberVO {
    private String member_id;
    private String member_pw;
    private String member_name;
    private String member_phone;
}
