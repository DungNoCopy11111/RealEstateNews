package com.example.realestate.service;

import com.example.realestate.dtos.dto.CityDTO;
import com.example.realestate.dtos.dto.DistrictDTO;
import com.example.realestate.dtos.dto.WardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    List<CityDTO> getAllCities();
    List<DistrictDTO> getAllDistricts(String cityName);
    List<WardDTO> getAllWards(String districtName);
}
