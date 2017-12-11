package com.ikrushyou.bluelightsserver.commandlinerunner;

import com.ikrushyou.bluelightsserver.bluelights.entity.Firecall;
import com.ikrushyou.bluelightsserver.bluelights.repository.FirecallRepository;
import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;
import com.ikrushyou.bluelightsserver.redalert.repository.DispCallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StarterCommandLineRunner  implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(StarterCommandLineRunner.class);

    @Autowired
    private DispCallRepository dispCallRepository;

    @Autowired
    private FirecallRepository firecallRepository;

    @Override
    public void run(String...args) throws Exception {
//        dispCallRepository.save(new DispCall("1234", "43 titus path"));
//        dispCallRepository.save(new DispCall("1234", "fdfds aff path"));
//        dispCallRepository.save(new DispCall("1234", "4asdff path"));
//        dispCallRepository.save(new DispCall("1234", "43 dfsfdth"));

//        dispCallRepository.findAll().forEach(System.out::println);
//
//        firecallRepository.save(new Firecall("sig 8", "43 titus path"));
//        firecallRepository.save(new Firecall("sig 8", "test address"));
//        firecallRepository.save(new Firecall("sig 8", "44 hillside ave"));
    }
}