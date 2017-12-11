package com.ikrushyou.bluelightsserver.controller;

import com.ikrushyou.bluelightsserver.bluelights.service.FirecallService;
import com.ikrushyou.bluelightsserver.redalert.service.DispCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Autowired
    private DispCallService dispCallService;

    @Autowired
    private FirecallService firecallService;

    @GetMapping("getnewcall")
    public String getNewCall() {


        return "";
    }
}
