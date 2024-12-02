package com.example.realestate.enums;

public enum Ward {
    // Phường thuộc Hoàn Kiếm - Hà Nội
    HANG_BAI("Hàng Bài", District.HOAN_KIEM),
    HANG_BO("Hàng Bồ", District.HOAN_KIEM),
    HANG_BUOM("Hàng Buồm", District.HOAN_KIEM),
    HANG_DAU("Hàng Đào", District.HOAN_KIEM),
    HANG_GAI("Hàng Gai", District.HOAN_KIEM),
    CHUONG_DUONG("Chương Dương", District.HOAN_KIEM),
    CUA_DONG("Cửa Đông", District.HOAN_KIEM),
    CUA_NAM("Cửa Nam", District.HOAN_KIEM),
    DONG_XUAN("Đồng Xuân", District.HOAN_KIEM),
    HANG_BAC("Hàng Bạc", District.HOAN_KIEM),
    HANG_TRONG("Hàng Trống", District.HOAN_KIEM),
    LY_THAI_TO("Lý Thái Tổ", District.HOAN_KIEM),
    PHAN_CHU_TRINH("Phan Chu Trinh", District.HOAN_KIEM),
    TRAN_HUNG_DAO("Trần Hưng Đạo", District.HOAN_KIEM),

    // Phường thuộc Ba Đình - Hà Nội
    NGOC_HA("Ngọc Hà", District.BA_DINH),
    THANH_CONG("Thành Công", District.BA_DINH),
    LIEU_GIAI("Liễu Giai", District.BA_DINH),
    QUAN_THANH("Quán Thánh", District.BA_DINH),
    PHUC_XA("Phúc Xá", District.BA_DINH),
    TRUC_BACH("Trúc Bạch", District.BA_DINH),
    VINH_PHUC("Vĩnh Phúc", District.BA_DINH),
    NGUYEN_TRUNG_TRUC("Nguyễn Trung Trực", District.BA_DINH),
    DIEN_BIEN("Điện Biên", District.BA_DINH),
    DOI_CAN("Đội Cấn", District.BA_DINH),
    GIANG_VO("Giảng Võ", District.BA_DINH),
    KIM_MA("Kim Mã", District.BA_DINH),

    // Phường thuộc Cầu Giấy - Hà Nội
    DICH_VONG("Dịch Vọng", District.CAU_GIAY),
    DICH_VONG_HAU("Dịch Vọng Hậu", District.CAU_GIAY),
    MAI_DICH("Mai Dịch", District.CAU_GIAY),
    NGHIA_DO("Nghĩa Đô", District.CAU_GIAY),
    NGHIA_TAN("Nghĩa Tân", District.CAU_GIAY),
    QUAN_HOA("Quan Hoa", District.CAU_GIAY),
    TRUNG_HOA("Trung Hòa", District.CAU_GIAY),
    YEN_HOA("Yên Hòa", District.CAU_GIAY),

    // Phường thuộc Quận 1 - TP.HCM
    BEN_NGHE("Bến Nghé", District.DISTRICT_1),
    BEN_THANH("Bến Thành", District.DISTRICT_1),
    CAU_KHO("Cầu Kho", District.DISTRICT_1),
    CO_GIANG("Cô Giang", District.DISTRICT_1),
    DA_KAO("Đa Kao", District.DISTRICT_1),
    NGUYEN_CU_TRINH("Nguyễn Cư Trinh", District.DISTRICT_1),
    NGUYEN_THAI_BINH("Nguyễn Thái Bình", District.DISTRICT_1),
    PHAM_NGU_LAO("Phạm Ngũ Lão", District.DISTRICT_1),
    TAM_DAO("Tân Định", District.DISTRICT_1),
    THAI_BINH("Thái Bình", District.DISTRICT_1),

    PHUC_LONG("Phước Long", District.TAN_BINH),  // Thêm lại phường bị thiếu
    TAN_SON_HOA("Tân Sơn Hòa", District.TAN_BINH),
    TAN_THANH("Tân Thành", District.TAN_BINH),
    TAN_BINH_WARD("Tân Bình", District.TAN_BINH),
    TAN_QUI("Tân Quý", District.TAN_BINH),

    // Phường thuộc Thủ Đức - TP.HCM
    BINH_THO("Bình Thọ", District.THU_DUC),
    HIEP_BINH_CHANH("Hiệp Bình Chánh", District.THU_DUC),
    HIEP_BINH_PHUOC("Hiệp Bình Phước", District.THU_DUC),
    LINH_CHIEU("Linh Chiểu", District.THU_DUC),
    LINH_DONG("Linh Đông", District.THU_DUC),
    LINH_TAY("Linh Tây", District.THU_DUC),
    LINH_XUAN("Linh Xuân", District.THU_DUC),
    TAM_BINH("Tam Bình", District.THU_DUC),
    TAM_PHU("Tam Phú", District.THU_DUC),
    TRUONG_THO("Trường Thọ", District.THU_DUC),

    // Phường thuộc Hải Châu - Đà Nẵng
    HAI_CHAU_1("Hải Châu 1", District.HAI_CHAU),
    HAI_CHAU_2("Hải Châu 2", District.HAI_CHAU),
    THUAN_PHUOC("Thuận Phước", District.HAI_CHAU),
    THANH_BINH("Thanh Bình", District.HAI_CHAU),
    HOA_CUONG_BAC("Hòa Cường Bắc", District.HAI_CHAU),
    HOA_CUONG_NAM("Hòa Cường Nam", District.HAI_CHAU),
    NAM_DUONG("Nam Dương", District.HAI_CHAU),
    PHUOC_NINH("Phước Ninh", District.HAI_CHAU),
    THACH_THANG("Thạch Thang", District.HAI_CHAU),
    BINH_HIEN("Bình Hiên", District.HAI_CHAU),

    // Phường thuộc Sơn Trà - Đà Nẵng
    AN_HAI_BAC("An Hải Bắc", District.SON_TRA),
    AN_HAI_DONG("An Hải Đông", District.SON_TRA),
    AN_HAI_TAY("An Hải Tây", District.SON_TRA),
    MAN_THAI("Mân Thái", District.SON_TRA),
    NAI_HIEN_DONG("Nại Hiên Đông", District.SON_TRA),
    PHO_NAM_SON_TRA("Phố Nam", District.SON_TRA),
    THO_QUANG("Thọ Quang", District.SON_TRA),

    // Phường thuộc Hồng Bàng - Hải Phòng
    HOANG_VAN_THU("Hoàng Văn Thụ", District.HONG_BANG),
    MINH_KHAI("Minh Khai", District.HONG_BANG),
    QUAN_TOAN("Quán Toan", District.HONG_BANG),
    SO_DAU("Sở Dầu", District.HONG_BANG),
    THANG_LOI("Thắng Lợi", District.HONG_BANG),
    TRAI_CHUOI("Trại Chuối", District.HONG_BANG),

    // Phường thuộc Ninh Kiều - Cần Thơ
    CAI_KHE("Cái Khế", District.NINH_KIEU),
    AN_HOA("An Hòa", District.NINH_KIEU),
    AN_NGHIEP("An Nghiệp", District.NINH_KIEU),
    AN_CU("An Cư", District.NINH_KIEU),
    TAN_AN("Tân An", District.NINH_KIEU),
    THOI_BINH("Thới Bình", District.NINH_KIEU),
    XUAN_KHANH("Xuân Khánh", District.NINH_KIEU),
    HUNG_LOI("Hưng Lợi", District.NINH_KIEU),
    AN_BINH("An Bình", District.NINH_KIEU),

    // Phường thuộc Biên Hòa - Đồng Nai
    QUANG_VINH("Quang Vinh", District.BIEN_HOA),
    QUYET_THANG("Quyết Thắng", District.BIEN_HOA),
    TAN_MAI("Tân Mai", District.BIEN_HOA),
    TAN_TIEN("Tân Tiến", District.BIEN_HOA),
    THANH_BINH_BIEN_HOA("Thanh Bình", District.BIEN_HOA),
    TRUNG_DUNG("Trung Dũng", District.BIEN_HOA),
    HOA_BINH("Hòa Bình", District.BIEN_HOA),
    LONG_BINH("Long Bình", District.BIEN_HOA),
    TAN_HIEP("Tân Hiệp", District.BIEN_HOA),
    TAN_HOA("Tân Hòa", District.BIEN_HOA),

    // Phường thuộc Thủ Dầu Một - Bình Dương
    PHU_CUONG("Phú Cường", District.THU_DAU_MOT),
    PHU_HOA("Phú Hòa", District.THU_DAU_MOT),
    PHU_LOI("Phú Lợi", District.THU_DAU_MOT),
    PHU_THO("Phú Thọ", District.THU_DAU_MOT),
    CHANH_NGHIA("Chánh Nghĩa", District.THU_DAU_MOT),
    DINH_HOA("Định Hòa", District.THU_DAU_MOT),
    HIEP_THANH("Hiệp Thành", District.THU_DAU_MOT),
    HOA_PHU("Hòa Phú", District.THU_DAU_MOT),
    PHU_TAN("Phú Tân", District.THU_DAU_MOT);

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