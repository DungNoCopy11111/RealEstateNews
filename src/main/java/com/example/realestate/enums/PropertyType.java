package com.example.realestate.enums;

public enum PropertyType {
    SALE("Nhà đất bán"),
    RENT("Nhà đất cho thuê");

    private final String displayName;

    PropertyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
