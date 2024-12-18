package com.practice.third.graphic_texture.service.response;

import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateResponse {
    private final String graphicTextureName;
    private final Long positionX;
    private final Long positionY;

    public static GraphicTextureCreateResponse from(String name, GraphicTexture graphicTexture) {
        return new GraphicTextureCreateResponse(
                name,
                graphicTexture.getPositionX(),
                graphicTexture.getPositionY());
    }
}
