package com.ikrushyou.bluelightsserver.redalert.repository;

import com.ikrushyou.bluelightsserver.redalert.entity.DispCall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DispCallRepository extends CrudRepository<DispCall, Integer> {

    @Query("from DispCall d where id in (select min(id) from DispCall where id > :id)")
    DispCall getNextAfter(@Param("id") Integer id);
}