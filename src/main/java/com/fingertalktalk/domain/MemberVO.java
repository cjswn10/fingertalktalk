package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by YJ on 2017-07-06.
 */
@Data
public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private int phone;
}
