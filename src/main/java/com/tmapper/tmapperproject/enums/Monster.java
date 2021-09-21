package com.tmapper.tmapperproject.enums;

import lombok.Getter;

@Getter
public enum Monster {
    FLIMSY("Flimsy Lost Soul"),
    RATS("Rat");

    private String name;

    Monster(String name) {
        this.name = name;
    }
}
