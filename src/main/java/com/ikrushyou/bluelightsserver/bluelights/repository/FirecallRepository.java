package com.ikrushyou.bluelightsserver.bluelights.repository;

import com.ikrushyou.bluelightsserver.bluelights.entity.Firecall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FirecallRepository extends CrudRepository<Firecall, Long> {

    @Query("from Firecall f where dispcallId in (select max(dispcallId) from Firecall)\n")
    Iterable<Firecall> getNewestFirecall();
}
