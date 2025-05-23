package net.weaverfever.stylishstiles.models;

import net.minecraft.block.Block;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.TextureKey;
import net.minecraft.client.data.TextureMap;

public class ModTextureMaps {

    public static TextureMap stileTexture(Block block)
    {
        return new TextureMap().put(TextureKey.TEXTURE, ModelIds.getBlockModelId(block));
    }

    public static TextureMap customStileTexture(Block block)
    {
        return new TextureMap()
                .put(TextureKey.TEXTURE, ModelIds.getBlockModelId(block))
                .put(TextureKey.PARTICLE, ModelIds.getBlockModelId(block));
    }
}
