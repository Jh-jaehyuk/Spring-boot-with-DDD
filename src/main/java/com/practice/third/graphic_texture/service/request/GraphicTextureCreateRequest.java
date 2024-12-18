package com.practice.third.graphic_texture.service.request;

import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateRequest {
    private final Long graphicTextureKindsNumber;
    private final Long cardNumber;

    public GraphicTexture toGraphicTexture(Long positionX, Long positionY) {
        return new GraphicTexture(positionX, positionY);
    }
}
