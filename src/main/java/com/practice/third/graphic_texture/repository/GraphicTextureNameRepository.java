package com.practice.third.graphic_texture.repository;

import com.practice.third.graphic_texture.entity.GraphicTextureName;

public interface GraphicTextureNameRepository {
    GraphicTextureName getGraphicTextureNameByValue(Long value);
}
