package com.practice.second.dice.repository;

import com.practice.second.dice.entity.Dice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiceRepository extends JpaRepository<Dice, Long> {
    List<Dice> findByIdIn(List<Long> ids);
}
