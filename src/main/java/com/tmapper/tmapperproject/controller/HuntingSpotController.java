package com.tmapper.tmapperproject.controller;

import com.tmapper.tmapperproject.entity.HuntingSpot;
import com.tmapper.tmapperproject.enums.City;
import com.tmapper.tmapperproject.repository.HuntingSpotRepository;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Data
@RequestMapping("/spots")
public class HuntingSpotController {

    public HuntingSpotController(HuntingSpotRepository huntingSpotRepository) {
        this.huntingSpotRepository = huntingSpotRepository;
    }

    private HuntingSpotRepository huntingSpotRepository;

    @GetMapping()
    public List<HuntingSpot> getAll() {
//        return huntingSpotRepository.findAll().size();
        return huntingSpotRepository.findAll();
    }

    @GetMapping("{name}")
    public String getByCity(@PathVariable String name) {
//        return name.getName();//todo converter string -> enum
        return "";
    }

    private City convertStringIntoCityEnum(String name) {
//        return Arrays.stream(City.values()).forEach();
    }

}