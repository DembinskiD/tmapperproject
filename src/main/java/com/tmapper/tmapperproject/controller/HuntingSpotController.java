package com.tmapper.tmapperproject.controller;

import com.tmapper.tmapperproject.entity.HuntingSpot;
import com.tmapper.tmapperproject.enums.City;
import com.tmapper.tmapperproject.repository.HuntingSpotRepository;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Converter;
import java.lang.annotation.Annotation;
import java.util.List;

@Controller
@Data
@RequestMapping("/spots")
public class HuntingSpotController {

    public HuntingSpotController(HuntingSpotRepository huntingSpotRepository) {
        this.huntingSpotRepository = huntingSpotRepository;
    }

    private HuntingSpotRepository huntingSpotRepository;

    @GetMapping
    public List<HuntingSpot> getAllByCity(@RequestParam String city) {

        return huntingSpotRepository.findAllByCity(City.valueOf(city));
    }
}