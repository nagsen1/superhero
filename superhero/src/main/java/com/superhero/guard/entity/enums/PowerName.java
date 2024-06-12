package com.superhero.guard.entity.enums;

public enum PowerName {

    PHOTON_BLAST("Photon-Blast"),
    FLIGHT("Flight"),
    SUPER_STRENGTH("Super-Strength"),
    HEALING("Healing"),
    GENIUS_INTELLIGENCE("Genius-Intelligence"),
    WEALTH("Wealth");

    private final String value;

    PowerName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
