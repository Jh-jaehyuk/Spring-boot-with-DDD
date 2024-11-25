package com.practice.first.dice.controller;

import com.practice.first.dice.entity.Dice;
import com.practice.first.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/first-dice")
public class DiceController {
    final private DiceService diceService;

    @GetMapping("/test")
    public String diceTest() {
        log.info("First-diceTest() called");

        return "First-diceTest() called";
    }

    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called");

        Dice acquiredDice = diceService.rollDice();

        return acquiredDice;
    }
}
