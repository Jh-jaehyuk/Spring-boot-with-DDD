package com.example.demo.dice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

// Entity 내부에 상태 값을 배치
// 이 상태 값을 획득하고 싶은 경우 사용하는 것이 Getter
// @Getter를 사용하여 getNumber() 메서드(함수)가 자동으로 생성됨

@Getter
@Entity
public class Dice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;
    private Long playerId;

    public Dice(long number) {
        this.number = number;
    }

    public Dice() {}
}
