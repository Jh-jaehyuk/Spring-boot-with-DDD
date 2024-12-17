package com.practice.third.graphic_texture.controller.response_form;

import com.practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateResponseForm {
    private final String graphicTextureName;
    private final Long positionX;
    private final Long positionY;

    public static GraphicTextureCreateResponseForm from(
            GraphicTextureCreateResponse graphicTextureCreateResponse) {
        return new GraphicTextureCreateResponseForm(
                graphicTextureCreateResponse.getGraphicTextureName(),
                graphicTextureCreateResponse.getPositionX(),
                graphicTextureCreateResponse.getPositionY()
        );
    }
}
