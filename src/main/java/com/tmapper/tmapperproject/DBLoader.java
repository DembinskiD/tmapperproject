package com.tmapper.tmapperproject;

import com.tmapper.tmapperproject.dataaccess.HuntingSpot;
import com.tmapper.tmapperproject.dataaccess.City;
import com.tmapper.tmapperproject.dataaccess.Monster;
import com.tmapper.tmapperproject.dataaccess.HuntingSpotRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
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

//    @Bean
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
        this.huntingSpotRepository.save(new HuntingSpot("venore elf", City.VENORE, Monster.ELF));
        this.huntingSpotRepository.save(new HuntingSpot("thais rat ab", City.AB, Monster.RAT));
        this.huntingSpotRepository.save(new HuntingSpot("carln flimsy", City.CARLIN, Monster.FLIMSY));
        this.huntingSpotRepository.save(new HuntingSpot("carln rats", City.CARLIN, Monster.RAT));
        this.huntingSpotRepository.save(new HuntingSpot("erd elf", City.EDRON, Monster.ELF));
        this.huntingSpotRepository.save(new HuntingSpot("edr dem", City.EDRON, Monster.DEMON));
        this.huntingSpotRepository.save(new HuntingSpot("car dem", City.CARLIN, Monster.DEMON));
    }
}
