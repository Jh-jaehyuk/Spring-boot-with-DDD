package com.practice.third.graphic_texture.repository;

import com.practice.third.graphic_texture.entity.GraphicTextureName;
import org.springframework.stereotype.Repository;

@Repository
public class GraphicTextureNameRepositoryImpl implements GraphicTextureNameRepository {
    @Override
    public GraphicTextureName getGraphicTextureNameByValue(Long value) {
        return GraphicTextureName.getGraphicTextureNameByValue(value);
    }
}
