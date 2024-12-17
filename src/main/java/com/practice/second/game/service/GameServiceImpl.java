package com.practice.second.game.service;

import com.practice.second.dice.entity.Dice;
import com.practice.second.dice.repository.DiceRepository;
import com.practice.second.game.entity.Game;
import com.practice.second.game.repository.GameRepository;
import com.practice.second.game.service.request.CheckGameRequest;
import com.practice.second.game.service.request.CreateSimpleGameRequest;
import com.practice.second.game.service.request.RecordGameWinnerRequest;
import com.practice.second.game.service.response.CheckGameResponse;
import com.practice.second.game.service.response.CreateSimpleGameResponse;
import com.practice.second.game.service.response.RecordGameWinnerResponse;
import com.practice.second.player.entity.Player;
import com.practice.second.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final DiceRepository diceRepository;

    final int DRAW = -1;

    @Override
//    @Transactional
    public CreateSimpleGameResponse createSimpleGame() {
        List<Player> playerList = playerRepository.findAll(); // findAll() -> 모든 player 객체를 가져옴
        List<Long> playerIdList = new ArrayList<>();

        for (Player player: playerList) {
            System.out.println("player: " + player);
            player.clearDiceIdList(); // 매 게임마다 새롭게 주사위 3번을 던지도록 주사위 목록 초기화
            for (int i = 0; i < 3; i++) {
                long randomNumber = (long)(Math.random() * 6) + 1; // 1 - 6 사이의 수가 랜덤으로 등장

                Dice dice = new Dice(randomNumber); // 위에서 랜덤으로 생성한 숫자를 가지는 dice 객체 생성
                Dice createdDice = diceRepository.save(dice); // 위에서 생성한 dice 객체를 DB에 저장 및 반환
                player.addDiceId(createdDice.getNumber()); // 생성된 dice 객체의 숫자를 player의 diceIdList에 추가
                player = playerRepository.save(player); // 변경된 diceIdList를 반영할 수 있도록 player 객체 저장
            }

            playerIdList.add((long)player.getId());
        }

        CreateSimpleGameRequest createSimpleGameRequest = new CreateSimpleGameRequest(playerIdList);
        Game game = createSimpleGameRequest.toGame();
        Game createdGame = gameRepository.save(game);

        return CreateSimpleGameResponse.from(createdGame.getId());
    }

    private List<Player> findPotentialWinners(List<Player> playerList) {
        int highestSum = 0;
        List<Player> potentialWinners = new ArrayList<>();

        for (Player player: playerList) {
            List<Long> diceList = player.getDiceIdList();
            System.out.println("player diceList: " + Arrays.toString(diceList.toArray()));
            int diceSum = calculateDiceSum(player);
            System.out.println("player: " + player + " diceSum: " + diceSum);
            if (diceSum > highestSum) {
                highestSum = diceSum;
                potentialWinners.clear();
                potentialWinners.add(player);
            }
            else if (diceSum == highestSum) {
                potentialWinners.add(player);
            }
        }

        return potentialWinners;
    }

    private int calculateDiceSum(Player player) {
        return player.getDiceIdList().stream().mapToInt(Long::intValue).sum();
    }

    @Override
    public RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest recordGameWinnerRequest) {
        Optional<Game> maybeGame = gameRepository.findById(recordGameWinnerRequest.getGameId());

        if (maybeGame.isEmpty()) {
            return RecordGameWinnerResponse.gameNotFound();
        }

        Game game = maybeGame.get();
        List<Long> playerIdList = game.getPlayerIdList();

        if (playerIdList.isEmpty()) {
            return RecordGameWinnerResponse.noPlayers();
        }

        List<Player> playerList = playerRepository.findByIdIn(playerIdList);
        List<Player> potentialWinners = findPotentialWinners(playerList);
        System.out.println("potentialWinners: " + Arrays.toString(potentialWinners.toArray()));

        if (potentialWinners.size() > 1) {
            game.setWinnerId(DRAW);
            gameRepository.save(game);
            return RecordGameWinnerResponse.draw();
        }

        Player winner = potentialWinners.getFirst();
        game.setWinnerId(winner.getId());
        gameRepository.save(game);

        return RecordGameWinnerResponse.winner(winner.getNickname());
    }

    @Override
    public CheckGameResponse checkGame(CheckGameRequest checkGameRequest) {
        Optional<Game> maybeGame = gameRepository.findById(checkGameRequest.getGameId());

        if (maybeGame.isEmpty()) {
            return new CheckGameResponse("게임을 찾을 수 없습니다.");
        }

        Game game = maybeGame.get();
        int winnerId = game.getWinnerId();
        System.out.println("WinnerId: " + winnerId);

        if (winnerId <= 0) {
            return new CheckGameResponse("게임의 승자가 없습니다.");
        }

        return new CheckGameResponse("승자: " + winnerId);
    }
}
