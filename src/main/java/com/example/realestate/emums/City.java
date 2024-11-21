package com.example.realestate.emums;

public enum City {
    HANOI("Hà Nội"),
    HO_CHI_MINH("Thành phố Hồ Chí Minh"),
    DA_NANG("Đà Nẵng"),
    HAI_PHONG("Hải Phòng"),
    ;

    private final String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
