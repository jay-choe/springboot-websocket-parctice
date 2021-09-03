package com.jay.sockettest.socket;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RequestController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping("/")
    public String getIndexPage() {
        log.info("index page");
        return "index.html";
    }
    @RequestMapping("/info")
    @ResponseBody
    public boolean socketDataSend() {
        simpMessagingTemplate.setMessageConverter(new StringMessageConverter());
        simpMessagingTemplate.convertAndSend("/topic", LocalDateTime.now().toString());
        return true;
    }
}
