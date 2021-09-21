package com.tmapper.tmapperproject.dataaccess;

import java.util.Arrays;

public enum Vocation {
    NONE, DRUID, KNIGHT, PALADIN, SORCERER;

    public static Vocation getVocationFromString(String vocation) {
        return Arrays.stream(values()).filter(voc -> voc.name().equalsIgnoreCase(vocation)).findFirst().orElse(NONE);
    }
}
