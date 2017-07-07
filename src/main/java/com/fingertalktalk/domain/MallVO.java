package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by HYEYOON on 2017-07-07.
 */
@Data
public class MallVO {
    int mall_idx;
    String mall_name;
    String server_name;
    String mall_img;
    String auto_login_url;
    Boolean is_cafe24;
}
