package com.tmapper.tmapperproject.dataaccess;

import com.tmapper.tmapperproject.dataaccess.HuntingSpot;
import com.tmapper.tmapperproject.dataaccess.City;
import com.tmapper.tmapperproject.dataaccess.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HuntingSpotRepository extends JpaRepository<HuntingSpot, Long> {

    List<HuntingSpot> findAllByCity(City city);
    List<HuntingSpot> findAllByMonster(Monster monster);

}
