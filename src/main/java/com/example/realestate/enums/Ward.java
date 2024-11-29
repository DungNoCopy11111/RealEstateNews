package com.example.realestate.enums;

public enum Ward {
    HANG_BAI("Hàng Bài", District.HOAN_KIEM),
    NGOC_HA("Ngọc Hà", District.BA_DINH),
    PHUC_LONG("Phước Long", District.TAN_BINH),
    BEN_NGHE("Bến Nghé", District.DISTRICT_1),
    AN_HAI_BAC("An Hải Bắc", District.SON_TRA),
    HOA_CUONG("Hòa Cường", District.HAI_CHAU),
    CAT_DAI("Cát Dài", District.LE_CHAN),
    HUNG_VUONG("Hùng Vương", District.NGHI_TAM),
    AN_THOI("An Thới", District.BINH_THUY),
    LE_BINH("Lê Bình", District.CAI_RANG);

    private final String name;
    private final District district;

    Ward(String name, District district) {
        this.name = name;
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public District getDistrict() {
        return district;
    }
}
