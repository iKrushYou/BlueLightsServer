package com.ikrushyou.bluelightsserver.redalert.service;

import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;
import com.ikrushyou.bluelightsserver.redalert.repository.DispCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("redalertService")
@Transactional("redalertTransactionManager")
public class DispCallService {

    @Autowired
    private DispCallRepository dispCallRepository;

    public List<DispCall> getAll() {
        List<DispCall> dispCallList = new ArrayList<>();
        dispCallRepository.findAll().forEach(dispCallList::add);
        return dispCallList;
    }

    public DispCall getNextAfter(Integer id) {
        return dispCallRepository.getNextAfter(id);
    }
}
