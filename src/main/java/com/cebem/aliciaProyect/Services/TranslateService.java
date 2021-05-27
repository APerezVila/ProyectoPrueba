package com.cebem.aliciaProyect.Services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslateService {
    @Autowired
    RestTemplate rTemplate;

    public String getTranslation(String sentence){
        String url = "https://api.mymemory.translated.net/get?q=" + sentence + "&langpair=es|en";
        JSONObject json = rTemplate.getForObject(url, JSONObject.class);
        return json.getString("translatedText");
    }
}
