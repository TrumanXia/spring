package com.xyg.learn.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LongProcessController {
    @RequestMapping("/long-process")
    public String pause() throws InterruptedException {
        Thread.sleep(20*1000);
        System.out.println("Process finished");
        return "Process finished";
    }
}
