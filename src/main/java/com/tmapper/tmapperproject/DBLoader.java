package com.tmapper.tmapperproject;

import com.tmapper.tmapperproject.entity.HuntingSpot;
import com.tmapper.tmapperproject.enums.City;
import com.tmapper.tmapperproject.enums.Monster;
import com.tmapper.tmapperproject.repository.HuntingSpotRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Data
public class DBLoader implements CommandLineRunner {

    private HuntingSpotRepository huntingSpotRepository;

    @Autowired
    public DBLoader(HuntingSpotRepository huntingSpotRepository) {
        this.huntingSpotRepository = huntingSpotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.huntingSpotRepository.save(new HuntingSpot("venore flimsy"));
        this.huntingSpotRepository.save(new HuntingSpot("ph flimsy"));
        this.huntingSpotRepository.save(new HuntingSpot("thais rats"));
        this.huntingSpotRepository.save(new HuntingSpot("thais rats", City.VENORE, Monster.RATS));
    }
}
