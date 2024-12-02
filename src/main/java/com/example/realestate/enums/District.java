package com.example.realestate.enums;

public enum District {
    // Hà Nội
    HOAN_KIEM("Hoàn Kiếm", City.HANOI),
    BA_DINH("Ba Đình", City.HANOI),
    DONG_DA("Đống Đa", City.HANOI),
    HAI_BA_TRUNG("Hai Bà Trưng", City.HANOI),
    HOANG_MAI("Hoàng Mai", City.HANOI),
    THANH_XUAN("Thanh Xuân", City.HANOI),
    LONG_BIEN("Long Biên", City.HANOI),
    NAM_TU_LIEM("Nam Từ Liêm", City.HANOI),
    BAC_TU_LIEM("Bắc Từ Liêm", City.HANOI),
    TAY_HO("Tây Hồ", City.HANOI),
    CAU_GIAY("Cầu Giấy", City.HANOI),
    HA_DONG("Hà Đông", City.HANOI),
    SON_TAY("Sơn Tây", City.HANOI),
    BA_VI("Ba Vì", City.HANOI),
    CHUONG_MY("Chương Mỹ", City.HANOI),

    // TP.HCM
    DISTRICT_1("Quận 1", City.HO_CHI_MINH),
    DISTRICT_3("Quận 3", City.HO_CHI_MINH),
    DISTRICT_4("Quận 4", City.HO_CHI_MINH),
    DISTRICT_5("Quận 5", City.HO_CHI_MINH),
    DISTRICT_6("Quận 6", City.HO_CHI_MINH),
    DISTRICT_7("Quận 7", City.HO_CHI_MINH),
    DISTRICT_8("Quận 8", City.HO_CHI_MINH),
    DISTRICT_10("Quận 10", City.HO_CHI_MINH),
    DISTRICT_11("Quận 11", City.HO_CHI_MINH),
    DISTRICT_12("Quận 12", City.HO_CHI_MINH),
    BINH_THANH("Bình Thạnh", City.HO_CHI_MINH),
    THU_DUC("Thủ Đức", City.HO_CHI_MINH),
    GO_VAP("Gò Vấp", City.HO_CHI_MINH),
    PHU_NHUAN("Phú Nhuận", City.HO_CHI_MINH),
    TAN_BINH("Tân Bình", City.HO_CHI_MINH),
    TAN_PHU("Tân Phú", City.HO_CHI_MINH),
    BINH_TAN("Bình Tân", City.HO_CHI_MINH),
    CU_CHI("Củ Chi", City.HO_CHI_MINH),
    HOC_MON("Hóc Môn", City.HO_CHI_MINH),
    BINH_CHANH("Bình Chánh", City.HO_CHI_MINH),
    NHA_BE("Nhà Bè", City.HO_CHI_MINH),
    CAN_GIO("Cần Giờ", City.HO_CHI_MINH),

    // Đà Nẵng
    HAI_CHAU("Hải Châu", City.DA_NANG),
    THANH_KHE("Thanh Khê", City.DA_NANG),
    SON_TRA("Sơn Trà", City.DA_NANG),
    NGU_HANH_SON("Ngũ Hành Sơn", City.DA_NANG),
    LIEN_CHIEU("Liên Chiểu", City.DA_NANG),
    CAM_LE("Cẩm Lệ", City.DA_NANG),
    HOA_VANG("Hòa Vang", City.DA_NANG),

    // Hải Phòng
    HONG_BANG("Hồng Bàng", City.HAI_PHONG),
    NGO_QUYEN("Ngô Quyền", City.HAI_PHONG),
    LE_CHAN("Lê Chân", City.HAI_PHONG),
    HAI_AN("Hải An", City.HAI_PHONG),
    KIEN_AN("Kiến An", City.HAI_PHONG),
    DO_SON("Đồ Sơn", City.HAI_PHONG),
    DUONG_KINH("Dương Kinh", City.HAI_PHONG),

    // Bình Dương
    THU_DAU_MOT("Thủ Dầu Một", City.BINH_DUONG),
    THUAN_AN("Thuận An", City.BINH_DUONG),
    DI_AN("Dĩ An", City.BINH_DUONG),
    TAN_UYEN("Tân Uyên", City.BINH_DUONG),
    BEN_CAT("Bến Cát", City.BINH_DUONG),
    DAU_TIENG("Dầu Tiếng", City.BINH_DUONG),

    // Đồng Nai
    BIEN_HOA("Biên Hòa", City.DONG_NAI),
    LONG_KHANH("Long Khánh", City.DONG_NAI),
    NHON_TRACH("Nhơn Trạch", City.DONG_NAI),
    VINH_CUU("Vĩnh Cửu", City.DONG_NAI),
    TRANG_BOM("Trảng Bom", City.DONG_NAI),
    THONG_NHAT("Thống Nhất", City.DONG_NAI),

    // Bắc Ninh
    BAC_NINH_CITY("Thành phố Bắc Ninh", City.BAC_NINH),
    TU_SON("Từ Sơn", City.BAC_NINH),
    TIEN_DU("Tiên Du", City.BAC_NINH),
    YEN_PHONG("Yên Phong", City.BAC_NINH),

    // Quảng Ninh
    HA_LONG("Hạ Long", City.QUANG_NINH),
    CAM_PHA("Cẩm Phả", City.QUANG_NINH),
    UONG_BI("Uông Bí", City.QUANG_NINH),
    MONG_CAI("Móng Cái", City.QUANG_NINH),

    // Khánh Hòa
    NHA_TRANG("Nha Trang", City.KHANH_HOA),
    CAM_RANH("Cam Ranh", City.KHANH_HOA),
    NINH_HOA("Ninh Hòa", City.KHANH_HOA),

    // Cần Thơ
    NINH_KIEU("Ninh Kiều", City.CAN_THO),
    CAI_RANG("Cái Răng", City.CAN_THO),
    BINH_THUY("Bình Thủy", City.CAN_THO),
    O_MON("Ô Môn", City.CAN_THO),
    THOT_NOT("Thốt Nốt", City.CAN_THO);

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