package com.example.realestate.enums;

public enum PropertyDirection {
    EAST("Đông"),
    WEST("Tây"),
    SOUTH("Nam"),
    NORTH("Bắc"),
    NORTHEAST("Đông Bắc"),
    SOUTHEAST("Đông Nam"),
    NORTHWEST("Tây Bắc"),
    SOUTHWEST("Tây Nam");

    private final String displayName;

    PropertyDirection(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }     // Tây Nam
}
