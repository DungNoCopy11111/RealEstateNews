package com.example.realestate.dtos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardDTO {
    private String code;
    private String name;
    private String districtCode;
}
