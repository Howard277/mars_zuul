package com.mars.mars_zuul.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by wuketao on 2018/5/24.
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @PostMapping(value = "getAuth")
    public String getAuth(@RequestBody String ticket) {
        return ticket;
    }
}
