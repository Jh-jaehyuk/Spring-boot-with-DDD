package com.practice.first.game.controller;

import com.practice.first.game.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/first-game")
public class GameController {
    final private GameService gameService;

    @RequestMapping("/play")
    public String playGame() {
        log.info("Game has been started!");

        String result = gameService.play();

        if (result.equals("DRAW!") || result.equals("게임을 플레이하려면 최소 2명의 플레이어가 필요합니다!\n플레이어를 생성하세요.")) {
            return result;
        }
        else {
            return String.format("승자는 %s 입니다!", result);
        }
    }
}
