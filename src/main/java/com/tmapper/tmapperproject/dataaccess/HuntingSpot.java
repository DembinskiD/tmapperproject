package com.tmapper.tmapperproject.dataaccess;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class HuntingSpot {

    public HuntingSpot() {
    }

    public HuntingSpot(String name) {
        this.name = name;
        this.city = City.THAIS;
        this.monster = Monster.RAT;
        teamVocations = new ArrayList<>();
    }

    public HuntingSpot(String name, City city, Monster monster) {
        this.name = name;
        this.city = city;
        this.monster = monster;
        teamVocations = new ArrayList<>();
    }

    @Id @GeneratedValue private Long id;
    private String name;
    @Enumerated(EnumType.STRING)  private City city;
    @Enumerated(EnumType.STRING) private Monster monster;
    private List<Vocation> teamVocations;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HuntingSpot that = (HuntingSpot) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
