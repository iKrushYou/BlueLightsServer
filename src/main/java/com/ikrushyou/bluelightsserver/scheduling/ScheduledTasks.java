package com.ikrushyou.bluelightsserver.scheduling;

import com.ikrushyou.bluelightsserver.bluelights.entity.Firecall;
import com.ikrushyou.bluelightsserver.bluelights.service.FirecallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }


    @Autowired
    private FirecallService firecallService;

    private Boolean waitingForNew = false;

    @Scheduled(fixedRate = 5000)
    public void getNewFirecalls() {
        Firecall lastFirecall = firecallService.getNewest();
        if (!waitingForNew) log.info("looking for new firecall (last: " + lastFirecall + ")");
        Firecall newFirecall = firecallService.copyNextFromRedAlert();
        if (newFirecall != null) {
            waitingForNew = false;
            if (!waitingForNew) log.info("new firecall added: " + newFirecall);
        } else {
            if (!waitingForNew) log.info("no new firecalls");
            waitingForNew = true;
        }
    }
}