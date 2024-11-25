package com.practice.first.dice.repository;

import com.practice.first.dice.entity.Dice;
import org.springframework.stereotype.Repository;

@Repository
public class DiceRepositoryImpl implements DiceRepository{
    final int MIN = 1;
    final int MAX = 6;

    private int createRandomNumber() {
        int randomNumber = (int)(Math.random() * MAX) + MIN;
        return randomNumber;
    }

    @Override
    public Dice rollDice() {
        int randomNumber = createRandomNumber();

        Dice dice = new Dice(randomNumber);
        return dice;
    }
}
