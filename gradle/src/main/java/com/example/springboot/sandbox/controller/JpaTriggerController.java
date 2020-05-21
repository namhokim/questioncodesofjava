package com.example.springboot.sandbox.controller;

import com.example.springboot.sandbox.repository.entity.City;
import com.example.springboot.sandbox.repository.CityRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class JpaTriggerController {
    private final CityRepository cityRepository;

    public JpaTriggerController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/jpa/city")
    public City getCity(@RequestParam String name, @RequestParam String state) {
        return cityRepository.findByNameAndStateAllIgnoringCase(name, state);
    }

    @PostMapping("/jpa/city")
    public City getCity(@RequestBody City city) {
        return cityRepository.save(city);
    }
}
