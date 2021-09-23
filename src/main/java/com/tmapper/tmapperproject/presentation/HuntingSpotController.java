package com.tmapper.tmapperproject.presentation;

import com.tmapper.tmapperproject.dataaccess.*;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return huntingSpotRepository.findAll();
    }

    @GetMapping("/city/{name}")
    public List<HuntingSpot> getByCity(@PathVariable String city) {
        return huntingSpotRepository.findAllByCity(convertStringIntoCityEnum(city));
    }

    @GetMapping("/monster/{monster}")
    public List<HuntingSpot> getByMonster(@PathVariable String monster) {
        return huntingSpotRepository.findAllByMonster(convertStringIntoMonsterEnum(monster));
    }

    @GetMapping("/vocation/{voc}")
    public List<HuntingSpot> getByVocation(@PathVariable String vocation) {
        Vocation voc = Vocation.getVocationFromString(vocation);
        return new ArrayList<>();
    }

    private Monster convertStringIntoMonsterEnum(String name) {
        return Arrays.stream(Monster.values())
                .filter(monster -> monster.name().equalsIgnoreCase(name))
                .findFirst().orElse(Monster.NONE);
    }

    private City convertStringIntoCityEnum(String name) {
        return Arrays.stream(City.values())
                .filter(city -> city.getName().equalsIgnoreCase(name))
                .findFirst().orElse(City.NONE);
    }

}