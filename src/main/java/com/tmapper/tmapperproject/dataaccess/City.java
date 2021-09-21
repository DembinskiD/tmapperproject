package com.tmapper.tmapperproject.dataaccess;

import lombok.Getter;

@Getter
public enum City {
    NONE("None"),
    CARLIN("Carlin"),
    EDRON("Edron"),
    VENORE("Venore"),
    THAIS("Thais"),
    AB("Ab'dendriel"),
    DARASHIA("Darashia"),
    ANKRAHMUN("Ankrahmun"),
    ROSHAMUUL("Roshamuul"),
    ORAMOND("Oramond"),
    KILMARESH("Kilmaresh");

    private String name;

    City(String name) {
        this.name = name;
    }

}
