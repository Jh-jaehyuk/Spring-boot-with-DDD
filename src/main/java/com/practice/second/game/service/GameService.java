package com.practice.second.game.service;

import com.practice.second.game.controller.response_form.CheckGameResponseForm;
import com.practice.second.game.service.request.CheckGameRequest;
import com.practice.second.game.service.request.RecordGameWinnerRequest;
import com.practice.second.game.service.response.CheckGameResponse;
import com.practice.second.game.service.response.CreateSimpleGameResponse;
import com.practice.second.game.service.response.RecordGameWinnerResponse;

public interface GameService {
    CreateSimpleGameResponse createSimpleGame();
    RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest recordGameWinnerRequest);
    CheckGameResponse checkGame(CheckGameRequest checkGameRequest);
}
