package com.fingertalktalk.controller;

import com.fingertalktalk.domain.Greeting;
import com.fingertalktalk.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YJ on 2017-08-16.
 */
@RestController
public class MessageHandler {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
