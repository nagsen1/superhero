package com.superhero.guard.entity.enums;

public enum PowerName {

    PHOTON_BLAST("Photon-Blast"),
    FLIGHT("Flight"),
    SUPER_STRENGTH("Super-Strength"),
    HEALING("Healing"),
    GENIUS_INTELLIGENCE("Genius-Intelligence"),
    WEALTH("Wealth");

    private final String displayName;

    private PowerName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
