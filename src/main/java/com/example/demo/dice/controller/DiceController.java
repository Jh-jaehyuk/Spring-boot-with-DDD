package com.example.demo.dice.controller;

import com.example.demo.dice.entity.Dice;
import com.example.demo.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// RestController는 기본적으로 다루는 데이터를 전부 JSON으로 처리
// Slf4j는 기본적으로 로그를 작성할 때 활용

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dice")
public class DiceController {
    final private DiceService diceService;

    @GetMapping("/test")
    public String diceTest() {
        log.info("diceTest() called");

        return "diceTest() called";
    }

    // Spring Framework에서는 json 리턴 타입을 맞추려면 class 타입으로 리턴해야합니다.
    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called");

        Dice acquiredDice = diceService.rollDice();

        return acquiredDice;
    }
}
