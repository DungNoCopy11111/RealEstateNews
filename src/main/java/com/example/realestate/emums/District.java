package com.example.realestate.emums;

public enum District {
    HOAN_KIEM("Hoàn Kiếm", City.HANOI),
    TAN_BINH("Tân Bình", City.HO_CHI_MINH),
    SON_TRA("Sơn Trà", City.DA_NANG),
    ;

    private final String name;
    private final City city;

    District(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }
}
