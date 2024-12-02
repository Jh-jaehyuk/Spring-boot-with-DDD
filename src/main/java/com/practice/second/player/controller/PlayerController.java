package com.practice.second.player.controller;


import com.practice.second.player.controller.request_form.PlayerCreateRequestForm;
import com.practice.second.player.controller.request_form.PlayerFindRequestForm;
import com.practice.second.player.controller.response_form.PlayerCreateResponseForm;
import com.practice.second.player.controller.response_form.PlayerListResponseForm;
import com.practice.second.player.entity.Player;
import com.practice.second.player.service.PlayerService;
import com.practice.second.player.service.response.PlayerCreateResponse;
import com.practice.second.player.service.response.PlayerListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/second-player")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/create")
    public PlayerCreateResponseForm createPlayer(@ModelAttribute PlayerCreateRequestForm playerCreateRequestForm) {
        log.info("createPlayer() called!");

        PlayerCreateResponse response = playerService.createPlayer(playerCreateRequestForm.toPlayerCreateRequest());
        return PlayerCreateResponseForm.from(response);
    }

    @GetMapping("/find")
    public Player findPlayer(@ModelAttribute PlayerFindRequestForm playerFindRequestForm) {
        log.info("findPlayer() called!");

        Player foundPlayer = playerService.findPlayer(playerFindRequestForm.toPlayerFindRequest());
        return foundPlayer;
    }

    @GetMapping("/list")
    public List<PlayerListResponseForm> listPlayer() {
        log.info("listPlayer() called!");

        List<PlayerListResponse> responseList = playerService.listPlayer();

        return responseList.stream()
                .map(PlayerListResponseForm::from)
                .collect(Collectors.toList());
    }
}
