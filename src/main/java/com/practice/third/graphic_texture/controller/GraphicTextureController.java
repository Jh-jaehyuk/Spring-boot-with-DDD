package com.practice.third.graphic_texture.controller;

import com.practice.third.graphic_texture.controller.request_form.GraphicTextureCreateRequestForm;
import com.practice.third.graphic_texture.controller.response_form.GraphicTextureCreateResponseForm;
import com.practice.third.graphic_texture.service.GraphicTextureService;
import com.practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/graphic-texture")
public class GraphicTextureController {
    private final GraphicTextureService graphicTextureService;

    @PostMapping("/create")
    public GraphicTextureCreateResponseForm create(
            @RequestBody GraphicTextureCreateRequestForm graphicTextureCreateRequestForm) {
        log.info("graphic texture controller -> create() called!");

        GraphicTextureCreateResponse response = graphicTextureService.create(
                graphicTextureCreateRequestForm.toGraphicTextureCreateRequest());

        return GraphicTextureCreateResponseForm.from(response);
    }
}
