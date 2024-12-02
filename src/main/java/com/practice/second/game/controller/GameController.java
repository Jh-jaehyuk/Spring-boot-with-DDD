package com.practice.second.game.controller;

import com.practice.second.game.controller.request_form.CheckGameRequestForm;
import com.practice.second.game.controller.request_form.RecordGameWinnerRequestForm;
import com.practice.second.game.controller.response_form.CheckGameResponseForm;
import com.practice.second.game.controller.response_form.CreateSimpleGameResponseForm;
import com.practice.second.game.controller.response_form.RecordGameWinnerResponseForm;
import com.practice.second.game.service.GameService;
import com.practice.second.game.service.response.CheckGameResponse;
import com.practice.second.game.service.response.CreateSimpleGameResponse;
import com.practice.second.game.service.response.RecordGameWinnerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/second-game")
public class GameController {
    private final GameService gameService;

    @GetMapping("/create-simple-game")
    public CreateSimpleGameResponseForm createSimpleGame() {
        log.info("createSimpleGame() called!");

        CreateSimpleGameResponse response = gameService.createSimpleGame();

        return CreateSimpleGameResponseForm.from(response);
    }

    @GetMapping("/record-game-winner")
    public RecordGameWinnerResponseForm recordGameWinner(@ModelAttribute RecordGameWinnerRequestForm recordGameWinnerRequestForm) {
        log.info("recordGameWinner() called!");

        RecordGameWinnerResponse response = gameService.recordGameWinner(recordGameWinnerRequestForm.toRecordGameWinnerRequest());

        return RecordGameWinnerResponseForm.from(response);
    }

    @GetMapping("/check-game")
    public CheckGameResponseForm checkGame(@ModelAttribute CheckGameRequestForm checkGameRequestForm) {
        log.info("checkGame() called!");

        CheckGameResponse response = gameService.checkGame(checkGameRequestForm.toCheckGameRequest());

        return CheckGameResponseForm.from(response);
    }
}
