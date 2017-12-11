package com.ikrushyou.bluelightsserver.redalert.controller;

import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;
import com.ikrushyou.bluelightsserver.redalert.service.DispCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dispcalls")
public class DispCallController {

    @Autowired
    private DispCallService dispCallService;

    @RequestMapping(method = RequestMethod.GET)
    public List<DispCall> getAll() {
        return dispCallService.getAll();
    }

    @RequestMapping(value = "after/{id}", method = RequestMethod.GET)
    public DispCall getNextAfter(@PathVariable("id") Integer id) {
        return dispCallService.getNextAfter(id);
    }
}
