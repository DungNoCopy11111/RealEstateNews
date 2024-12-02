package com.example.realestate.enums;

public enum City {
    HANOI("Hà Nội"),
    HO_CHI_MINH("Thành phố Hồ Chí Minh"),
    HAI_PHONG("Hải Phòng"),
    DA_NANG("Đà Nẵng"),
    BINH_DUONG("Bình Dương"),
    DONG_NAI("Đồng Nai"),
    BAC_NINH("Bắc Ninh"),
    QUANG_NINH("Quảng Ninh"),
    KHANH_HOA("Khánh Hòa"),
    LONG_AN("Long An"),
    BA_RIA_VUNG_TAU("Bà Rịa Vũng Tàu"),
    CAN_THO("Cần Thơ"),
    BINH_THUAN("Bình Thuận"),
    LAM_DONG("Lâm Đồng"),
    THUA_THIEN_HUE("Thừa Thiên Huế"),
    KIEN_GIANG("Kiên Giang"),
    BAC_GIANG("Bắc Giang"),
    HAI_DUONG("Hải Dương"),
    HUNG_YEN("Hưng Yên"),
    BINH_PHUOC("Bình Phước"),
    TAY_NINH("Tây Ninh"),
    THANH_HOA("Thanh Hóa"),
    NGHE_AN("Nghệ An"),
    PHU_THO("Phú Thọ"),
    NAM_DINH("Nam Định"),
    VINH_PHUC("Vĩnh Phúc"),
    BINH_DINH("Bình Định"),
    THAI_NGUYEN("Thái Nguyên"),
    GIA_LAI("Gia Lai"),
    QUANG_NAM("Quảng Nam"),
    DAK_LAK("Đắk Lắk"),
    QUANG_NGAI("Quảng Ngãi"),
    PHU_YEN("Phú Yên"),
    HA_NAM("Hà Nam"),
    THAI_BINH("Thái Bình"),
    LANG_SON("Lạng Sơn"),
    QUANG_BINH("Quảng Bình"),
    AN_GIANG("An Giang"),
    QUANG_TRI("Quảng Trị"),
    BAC_KAN("Bắc Kạn"),
    VINH_LONG("Vĩnh Long"),
    NINH_BINH("Ninh Bình"),
    CA_MAU("Cà Mau"),
    SOC_TRANG("Sóc Trăng"),
    BEN_TRE("Bến Tre"),
    DAK_NONG("Đắk Nông"),
    TUYEN_QUANG("Tuyên Quang"),
    DONG_THAP("Đồng Tháp"),
    NINH_THUAN("Ninh Thuận"),
    KON_TUM("Kon Tum"),
    LAO_CAI("Lào Cai"),
    SON_LA("Sơn La"),
    TRA_VINH("Trà Vinh"),
    YEN_BAI("Yên Bái"),
    HOA_BINH("Hòa Bình"),
    HAU_GIANG("Hậu Giang"),
    BAC_LIEU("Bạc Liêu"),
    CAO_BANG("Cao Bằng"),
    LAI_CHAU("Lai Châu"),
    DIEN_BIEN("Điện Biên"),
    HA_GIANG("Hà Giang");

    private final String name;

    City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Phần District và Ward giữ nguyên như cũ