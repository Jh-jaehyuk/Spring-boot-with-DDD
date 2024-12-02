package com.practice.second.dice.controller;

import com.practice.second.dice.entity.Dice;
import com.practice.second.dice.service.DiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/second-dice")
public class DiceController {
    private final DiceService diceService;

    @GetMapping("/roll-dice")
    public Dice rollDice() {
        log.info("rollDice() called!");

        Dice acquiredDice = diceService.rollDice();

        return acquiredDice;
    }
}
