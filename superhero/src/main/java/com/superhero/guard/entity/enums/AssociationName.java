package com.superhero.guard.entity.enums;

public enum AssociationName {

    SPACE_STONE("Space-Stone"),
    SKRULLS("Skrulls"),
    PHOTON("Photon"),
    KREE("Kree"),
    AVENGERS("Avengers"),
    WAR_MACHINE("War-Machine"),
    JARVIS("Jarvis"),
    THANOS("Thanos"),
    PEPPER_POTTS("Pepper-Potts");

    private final String displayName;

    AssociationName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


