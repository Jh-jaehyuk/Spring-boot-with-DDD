package com.practice.third.graphic_texture.service;

import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import com.practice.third.graphic_texture.repository.GraphicTextureRepository;
import com.practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import com.practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;

public class GraphicTextureServiceImpl implements GraphicTextureService {
    private final GraphicTextureRepository graphicTextureRepository;

    @Override
    public GraphicTextureCreateResponse create(GraphicTextureCreateRequest graphicTextureCreateRequest) {
        Long randomPositionX = (long)(Math.random() * 200) + 1;
        Long randomPositionY = (long)(Math.random() * 200) + 1;

        Long cardNumber = graphicTextureCreateRequest.getCardNumber();
        String name = GraphicTextureName.getNameByValue(cardNumber);

        GraphicTexture graphicTexture = graphicTextureCreateRequest.toGraphicTexture(
                randomPositionX, randomPositionY);
        GraphicTexture createdGraphicTexture = graphicTextureRepository.save(graphicTexture);

        return GraphicTextureCreateResponse.from(name, createdGraphicTexture);
    }
}
