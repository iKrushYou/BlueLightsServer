package com.ikrushyou.bluelightsserver.bluelights.service;

import com.ikrushyou.bluelightsserver.bluelights.entity.Firecall;
import com.ikrushyou.bluelightsserver.bluelights.repository.FirecallRepository;
import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;
import com.ikrushyou.bluelightsserver.redalert.repository.DispCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("mainService")
@Transactional("transactionManager")
public class FirecallService {

    @Autowired
    private FirecallRepository firecallRepository;

    @Autowired
    private DispCallRepository dispCallRepository;

    public List<Firecall> getAll() {
        List<Firecall> firecalls = new ArrayList<>();
        firecallRepository.findAll().forEach(firecalls::add);
        return firecalls;
    }

    public Firecall getNewest() {
        Iterator<Firecall> iterator = firecallRepository.getNewestFirecall().iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }

    public Firecall copyNextFromRedAlert() {
        Firecall firecall = getNewest();

        DispCall dispCall = null;
        if (firecall == null) {
            dispCall = dispCallRepository.getNextAfter(0);
        } else {
            dispCall = dispCallRepository.getNextAfter(firecall.getDispcallId());
        }

        if (dispCall == null) {
            return null;
        } else {
            return firecallRepository.save(new Firecall(dispCall));
        }
    }
}
