package com.tmapper.tmapperproject.repository;

import com.tmapper.tmapperproject.entity.HuntingSpot;
import com.tmapper.tmapperproject.enums.City;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HuntingSpotRepository extends CrudRepository<HuntingSpot, Long> {

    List<HuntingSpot> findAllByCity(City city);
}
