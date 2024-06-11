package com.superhero.guard.entity.enums;

public enum WeaponName {

    ARC_REACTOR("arc-reactor"),
    IRON_MAN_SUIT("iron-man-suit"),
    IRON_LEGION("iron-legion");

    private final String displayName;

    private WeaponName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
