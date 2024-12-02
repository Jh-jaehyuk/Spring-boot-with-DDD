package com.practice.second.player.service;


import com.practice.second.dice.entity.Dice;
import com.practice.second.dice.repository.DiceRepository;
import com.practice.second.player.entity.Player;
import com.practice.second.player.repository.PlayerRepository;
import com.practice.second.player.service.request.PlayerCreateRequest;
import com.practice.second.player.service.request.PlayerFindRequest;
import com.practice.second.player.service.response.PlayerCreateResponse;
import com.practice.second.player.service.response.PlayerListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final DiceRepository diceRepository;

    @Override
    public PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest) {
        Player player = playerCreateRequest.toPlayer();
        Player createdPlayer = playerRepository.save(player);

        return PlayerCreateResponse.from(createdPlayer);
    }

    @Override
    public Player findPlayer(PlayerFindRequest playerFindRequest) {
        Optional<Player> maybePlayer = playerRepository.findById(playerFindRequest.getPlayerId());
        if (maybePlayer.isEmpty()) {
            log.info("해당 playerId로 찾는 Player가 없습니다.");
            return null;
        }

        return maybePlayer.get();
    }

    @Override
    public List<PlayerListResponse> listPlayer() {
        List<Player> playerList = playerRepository.findAll();

        return playerList.stream()
                .map(player -> {
                    List<Dice> diceList = diceRepository.findByIdIn(player.getDiceIdList());
                    return PlayerListResponse.from(player, diceList);
                })
                .collect(Collectors.toList());
    }
}
