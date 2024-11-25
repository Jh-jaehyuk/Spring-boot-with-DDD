package com.practice.first.dice.service;

import com.practice.first.dice.entity.Dice;
import com.practice.first.dice.repository.DiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    final private DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        return diceRepository.rollDice();
    }
}
