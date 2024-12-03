package com.practice.second.player.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "player_dice_ids") // 테이블 이름을 지정
//    @Column(name = "dice_id") // 컬럼 이름 지정
    private List<Long> diceIdList;

    public Player(String nickname) {
        this.nickname = nickname;
        this.diceIdList = new ArrayList<>();
    }

    public void addDiceId(Long diceId) {
        this.diceIdList.add(diceId);
    }

    public void clearDiceIdList() {
        this.diceIdList.clear();
    }

    public Player() {}
}
