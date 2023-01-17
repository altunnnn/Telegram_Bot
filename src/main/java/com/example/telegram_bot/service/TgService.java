package com.example.telegram_bot.service;

import com.example.telegram_bot.dto.RestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TgService {

    private Long offsets = null;

    public ResponseEntity requiers(){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.telegram.org/bot5691882521:AAEZwU-ppYvg1ArNN5KG-nPXnvEM4fw2eXA/getUpdates?offset={offset}";

        Map<String,String> params = new HashMap<>();
        params.put("offset", String.valueOf(offsets));

        ResponseEntity<RestDto> exchange = restTemplate.exchange(url, HttpMethod.GET,null,
                RestDto.class,params);
        if (exchange.getBody().result.size() > 0){
            offsets = (long) (exchange.getBody().result.get(0).update_id + 1);
        }
        System.out.println("No Messages");



        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);
    }





}
