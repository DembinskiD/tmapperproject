package com.tmapper.tmapperproject.entity;

import com.tmapper.tmapperproject.enums.City;
import com.tmapper.tmapperproject.enums.Monster;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class HuntingSpot {

    public HuntingSpot() {}

    public HuntingSpot(String name) {
        this.name = name;
        this.city = City.THAIS;
        this.mainMonster = Monster.RATS;
    }

    public HuntingSpot(String name, City city, Monster mainMonster) {
        this.name = name;
        this.city = city;
        this.mainMonster = mainMonster;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private City city;
    @Enumerated(EnumType.STRING)
    private Monster mainMonster;
//    private HuntingGroundMap map;


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
