package com.example.realestate.enums;

public enum Category {
    APARTMENT("Căn hộ chung cư"),
    HOME("Nhà riêng"),
    GROUNDLAND("Đất nền");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
