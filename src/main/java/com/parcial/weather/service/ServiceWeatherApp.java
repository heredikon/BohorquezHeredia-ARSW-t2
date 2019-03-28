/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial.weather.service;

import com.parcial.weather.connection.Connection;
import java.io.IOException;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 /*
 * @author 2094204
 */
@Service
public class ServiceWeatherApp {
    
    @Autowired
    Connection connection;
    
    HashMap<String,String> ciudadesVisitadas = new HashMap<>();
    
    
    public String getCityWeather(String name) throws IOException{
        
        connection.setCity(name);
        String info = connection.connect(); 
        return info;
    }
    
    
    
}
