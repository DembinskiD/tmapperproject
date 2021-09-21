package com.tmapper.tmapperproject;

import com.tmapper.tmapperproject.entity.HuntingSpot;
import com.tmapper.tmapperproject.enums.City;
import com.tmapper.tmapperproject.repository.HuntingSpotRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@Data
public class DBLoader implements CommandLineRunner {

    private HuntingSpotRepository huntingSpotRepository;

    ArrayList<String> monsters = new ArrayList<>();

    @Bean
    public void setMonsters() throws IOException {
        String file = "Tibia - Free Multiplayer Online Role Playing Game - Library.html";

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.contains("acidblob")) {
                break;
            }
        }
        assert line != null;
        Arrays.stream(line.split("<div>")).map(ln -> ln.substring(0, ln.indexOf("</div>"))).filter(l -> !l.contains("https")).forEach(monster -> monsters.add(monster));
    }

    @Autowired
    public DBLoader(HuntingSpotRepository huntingSpotRepository) {
        this.huntingSpotRepository = huntingSpotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.huntingSpotRepository.save(new HuntingSpot("venore flimsy"));
        this.huntingSpotRepository.save(new HuntingSpot("ph flimsy"));
        this.huntingSpotRepository.save(new HuntingSpot("thais rats"));
        this.huntingSpotRepository.save(new HuntingSpot("thais rats", City.VENORE, "rat"));
    }
}
