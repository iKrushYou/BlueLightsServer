package com.ikrushyou.bluelightsserver.bluelights.controller;

import com.ikrushyou.bluelightsserver.bluelights.entity.Firecall;
import com.ikrushyou.bluelightsserver.bluelights.service.FirecallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/firecalls")
public class FirecallController {

    @Autowired
    private FirecallService firecallService;

    @GetMapping
    public List<Firecall> getAll() {
        return firecallService.getAll();
    }

    @GetMapping("newest")
    public Firecall getNewest() {
        return firecallService.getNewest();
    }

    @RequestMapping(value = "getNewestFromRedalert")
    public Firecall getNewestFromRedalert() {
        return firecallService.copyNextFromRedAlert();
    }
}
