/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parcial.weather.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Connection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";
    private String KEY = "3b84a77d25ca5e61592200743df2326a";
    private static String info;

    public String connect() throws MalformedURLException, IOException {

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return (response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        return null;
    }

    public static String getGET_URL() {
        return GET_URL;
    }

    public static void setGET_URL(String GET_URL) {
        Connection.GET_URL = GET_URL;
    }

    public void setCity(String city) {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&APPID=" + KEY;
        setGET_URL(url);
    }

    public String getKEY() {
        return KEY;
    }

    public void setKEY(String KEY) {
        this.KEY = KEY;
    }

}
