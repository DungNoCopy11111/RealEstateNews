package com.example.realestate.enums;

public enum District {
    HOAN_KIEM("Hoàn Kiếm", City.HANOI),
    BA_DINH("Ba Đình", City.HANOI),
    TAN_BINH("Tân Bình", City.HO_CHI_MINH),
    DISTRICT_1("Quận 1", City.HO_CHI_MINH),
    SON_TRA("Sơn Trà", City.DA_NANG),
    HAI_CHAU("Hải Châu", City.DA_NANG),
    LE_CHAN("Lê Chân", City.HAI_PHONG),
    NGHI_TAM("Nghi Tàm", City.HAI_PHONG),
    BINH_THUY("Bình Thủy", City.CAN_THO),
    CAI_RANG("Cái Răng", City.CAN_THO);

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
