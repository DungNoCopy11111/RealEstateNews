package com.example.realestate.controller;

import com.example.realestate.dtos.dto.CityDTO;
import com.example.realestate.dtos.dto.DistrictDTO;
import com.example.realestate.dtos.dto.WardDTO;
import com.example.realestate.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/address")
@Slf4j
public class AddressController {
    @Autowired
    private final AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        log.info("Cities data: {}", addressService.getAllCities());
        return ResponseEntity.ok(addressService.getAllCities());
    }

    @GetMapping("/districts")
    public ResponseEntity<List<DistrictDTO>> getDistrictsByCity(
            @RequestParam String cityCode) {
        log.info("Success");
        return ResponseEntity.ok(addressService.getAllDistricts(cityCode));
    }

    @GetMapping("/wards")
    public ResponseEntity<List<WardDTO>> getWardsByDistrict(
            @RequestParam String districtCode) {
        log.info("Success");
        return ResponseEntity.ok(addressService.getAllWards(districtCode));
    }

}
