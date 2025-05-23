package net.weaverfever.stylishstiles.models;

import net.minecraft.client.data.Model;
import net.minecraft.client.data.TextureKey;
import net.minecraft.util.Identifier;
import net.weaverfever.stylishstiles.StylishStiles;

import java.util.Optional;

public class ModModels {
    public static final Model STILE = block("stile", TextureKey.TEXTURE);
    public static final Model CUSTOM_STILE = block("custom_stile", TextureKey.TEXTURE, TextureKey.PARTICLE);

    private static Model block(String parent, TextureKey... requiredTextureKeys)
    {
        return new Model(Optional.of(Identifier.of(StylishStiles.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys)
    {
        return new Model(Optional.of(Identifier.of(StylishStiles.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }
}


