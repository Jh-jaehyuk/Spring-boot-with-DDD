package com.practice.third.graphic_texture.service;

import com.practice.third.graphic_texture.entity.GraphicTexture;
import com.practice.third.graphic_texture.entity.GraphicTextureName;
import com.practice.third.graphic_texture.repository.GraphicTextureNameRepository;
import com.practice.third.graphic_texture.repository.GraphicTextureRepository;
import com.practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import com.practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GraphicTextureServiceImpl implements GraphicTextureService {
    private final GraphicTextureRepository graphicTextureRepository;
    private final GraphicTextureNameRepository graphicTextureNameRepository;

    @Override
    public GraphicTextureCreateResponse create(GraphicTextureCreateRequest graphicTextureCreateRequest) {
        Long randomPositionX = (long)(Math.random() * 200) + 1;
        Long randomPositionY = (long)(Math.random() * 200) + 1;
        GraphicTextureName graphicTextureName = graphicTextureNameRepository.getGraphicTextureNameByValue(
                graphicTextureCreateRequest.getGraphicTextureKindsNumber());
        GraphicTexture graphicTexture = graphicTextureCreateRequest.toGraphicTexture(
                graphicTextureName,
                randomPositionX,
                randomPositionY,
                graphicTextureCreateRequest.getCardNumber());
        GraphicTexture createdGraphicTexture = graphicTextureRepository.save(graphicTexture);

        return GraphicTextureCreateResponse.from(createdGraphicTexture);
    }
}
