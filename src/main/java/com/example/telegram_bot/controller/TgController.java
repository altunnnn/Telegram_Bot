package com.example.telegram_bot.controller;

import com.example.telegram_bot.service.TgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TgController {
    private final TgService tgService;

    @GetMapping("/tgBot")
    public ResponseEntity tgBot(){
        return tgService.requiers();
    }
}
