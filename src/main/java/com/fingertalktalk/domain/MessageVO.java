package com.fingertalktalk.domain;

import lombok.Data;

/**
 * Created by YJ on 2017-08-16.
 */
@Data
public class MessageVO {

    private String message;

    private String type;

    private String to;

    public static MessageVO converMessage(String source) {

        MessageVO message = new MessageVO();
message.message = source;


        return message;

    }
}