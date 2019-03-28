/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial.weather.controller;

import com.parcial.weather.service.ServiceWeatherApp;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 2094204
 */
@RestController
public class WeatherAppController {

    @Autowired
    ServiceWeatherApp service;

    @GetMapping(value = "/cities/{city}")
    public ResponseEntity<?> getCityInfo(@PathVariable("city") String city) throws IOException {
        String responce = service.getCityWeather(city);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

}
