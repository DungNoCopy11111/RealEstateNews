package com.example.realestate.service.impl;

import com.example.realestate.dtos.dto.CityDTO;
import com.example.realestate.dtos.dto.DistrictDTO;
import com.example.realestate.dtos.dto.WardDTO;
import com.example.realestate.enums.City;
import com.example.realestate.enums.District;
import com.example.realestate.enums.Ward;
import com.example.realestate.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
    @Override
    public List<CityDTO> getAllCities() {
        return Arrays.stream(City.values())
                .map(city -> new CityDTO(city.name(), city.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DistrictDTO> getAllDistricts(String cityName) {
        try {
            City city = City.valueOf(cityName);
            return Arrays.stream(District.values())
                    .filter(district -> district.getCity() == city)
                    .map(district -> new DistrictDTO(
                            district.name(),
                            district.getName(),
                            district.getCity().name()
                    ))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            log.error("Invalid city name: {}", cityName);
            return Collections.emptyList();
        }
    }

    @Override
    public List<WardDTO> getAllWards(String districtName) {
        try {
            District district = District.valueOf(districtName);
            return Arrays.stream(Ward.values())
                    .filter(ward -> ward.getDistrict() == district)
                    .map(ward -> new WardDTO(
                            ward.name(),
                            ward.getName(),
                            ward.getDistrict().name()
                    ))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            log.error("Invalid district name: {}", districtName);
            return Collections.emptyList();
        }
    }
}
