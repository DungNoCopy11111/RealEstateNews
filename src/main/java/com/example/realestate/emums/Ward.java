package com.example.realestate.emums;

public enum Ward {
    PHUC_LONG("Phước Long", District.TAN_BINH),
    ;

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
