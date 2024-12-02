package com.practice.second.player.repository;

import com.practice.second.player.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByIdIn(List<Long> playerIdList);
}
