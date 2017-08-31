package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by YJ on 2017-08-16.
 */
@Data
public class ChatName {
    private String id;
    private String name;

    public ChatName(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
