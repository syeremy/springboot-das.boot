package com.syeremy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by syeremy on 5/29/17.
 */

@RestController
public class HomeController {

    @RequestMapping("/")
    public  String home(){
        return "Das Boot, reporting for duty!";
    }
}
