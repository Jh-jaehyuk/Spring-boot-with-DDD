package com.practice.second.dice.service;

import com.practice.second.dice.entity.Dice;
import com.practice.second.dice.repository.DiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiceServiceImpl implements DiceService {
    private final DiceRepository diceRepository;

    @Override
    public Dice rollDice() {
        final int MIN = 1;
        final int MAX = 6;
        long randomNumber = (long)(Math.random() * MAX) + MIN;

        Dice dice = new Dice(randomNumber);
        Dice createdDice = diceRepository.save(dice);

        return createdDice;
    }
}
