package com.example.demo.dice.repository;

import com.example.demo.dice.entity.Dice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiceRepository extends JpaRepository<Dice, Long> {

}
