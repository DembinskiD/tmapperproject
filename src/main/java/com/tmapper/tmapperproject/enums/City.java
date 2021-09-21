package com.tmapper.tmapperproject.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum City {
    CARLIN("Carlin"),
    EDRON("Edron"),
    VENORE("Venore"),
    THAIS("Thais"),
    AB("Ab'dendriel");

    private String name;

    City(String name) {
        this.name = name;
    }

}
