package com.master.demo_mvc.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    private final String SITE_IS_UP = "site is up";
    private final String SITE_IS_DOWN = "site is Down";
    private final String INCORECT_URL = "URL is incorrect";

    @GetMapping("/check")
    public String getUrlStatusMsg(@RequestParam String url) {
        String msg = "";
        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() / 100 != 2)
                msg = SITE_IS_DOWN;
            else {
                msg = SITE_IS_UP;
            }
        } catch (IOException e) {
            return msg = INCORECT_URL;
        }
        return msg;
    }
}
