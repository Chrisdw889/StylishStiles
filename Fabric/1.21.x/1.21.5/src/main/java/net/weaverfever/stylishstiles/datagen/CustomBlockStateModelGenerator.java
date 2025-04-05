package net.weaverfever.stylishstiles.datagen;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.MultipartModelCondition;
import net.minecraft.client.render.model.json.MultipartModelConditionBuilder;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;
import net.weaverfever.stylishstiles.StylishStiles;
import net.weaverfever.stylishstiles.block.custom.Stile;

import java.util.Optional;
import java.util.Properties;

public class CustomBlockStateModelGenerator {

    public static final Model STILE = block("stile", TextureKey.TEXTURE);

    public static void registerStile(BlockStateModelGenerator generator, Block stileBlock, TextureMap textures)
    {
        Identifier stileModel = STILE.upload(stileBlock, textures, generator.modelCollector);
        Identifier fenceSideModel = Models.FENCE_SIDE.upload(stileBlock, textures, generator.modelCollector);
//        Identifier fenceSideModel = Identifier.of()
//        Identifier fenceSideNorthModel = Models.CUSTOM_FENCE_SIDE_NORTH.upload(stileBlock, textures, generator.modelCollector);
//        Identifier fenceSideEastModel = Models.CUSTOM_FENCE_SIDE_EAST.upload(stileBlock, textures, generator.modelCollector);
//        Identifier fenceSideSouthModel = Models.CUSTOM_FENCE_SIDE_SOUTH.upload(stileBlock, textures, generator.modelCollector);
//        Identifier fenceSideWestModel = Models.CUSTOM_FENCE_SIDE_WEST.upload(stileBlock, textures, generator.modelCollector);
        generator.blockStateCollector.accept(createStileBlockStates(stileBlock, varOf(stileModel), varOf(fenceSideModel)));
        generator.registerParentedItemModel(stileBlock, stileModel);
    }

    private static MultipartBlockModelDefinitionCreator createStileBlockStates(Block stileBlock, WeightedVariant stileId, WeightedVariant fenceSideId)
    {
        ModelVariantOperator r0 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R0);
        ModelVariantOperator r90 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90);
        ModelVariantOperator r180 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180);
        ModelVariantOperator r270 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270);
        ModelVariantOperator uvlock = ModelVariantOperator.UV_LOCK.withValue(true);

        MultipartModelConditionBuilder northFacingCondition = new MultipartModelConditionBuilder().put(Stile.FACING, Direction.NORTH);
        MultipartModelConditionBuilder eastFacingCondition = new MultipartModelConditionBuilder().put(Stile.FACING, Direction.EAST);
        MultipartModelConditionBuilder southFacingCondition = new MultipartModelConditionBuilder().put(Stile.FACING, Direction.SOUTH);
        MultipartModelConditionBuilder westFacingCondition = new MultipartModelConditionBuilder().put(Stile.FACING, Direction.WEST);

        MultipartModelConditionBuilder northConnectionCondition = new MultipartModelConditionBuilder().put(Stile.NORTH, true);
        MultipartModelConditionBuilder eastConnectionCondition = new MultipartModelConditionBuilder().put(Stile.EAST, true);
        MultipartModelConditionBuilder southConnectionCondition = new MultipartModelConditionBuilder().put(Stile.SOUTH, true);
        MultipartModelConditionBuilder westConnectionCondition = new MultipartModelConditionBuilder().put(Stile.WEST, true);

        return MultipartBlockModelDefinitionCreator.create(stileBlock)
                .with(northFacingCondition, stileId.apply(r0))
                .with(eastFacingCondition, stileId.apply(r90))
                .with(southFacingCondition, stileId.apply(r180))
                .with(westFacingCondition, stileId.apply(r270))
                .with(northConnectionCondition, fenceSideId.apply(uvlock).apply(r0))
                .with(eastConnectionCondition, fenceSideId.apply(uvlock).apply(r90))
                .with(southConnectionCondition, fenceSideId.apply(uvlock).apply(r180))
                .with(westConnectionCondition, fenceSideId.apply(uvlock).apply(r270));
    }

//    private static VariantsBlockModelDefinitionCreator createStileBlockStates(Block stileBlock, WeightedVariant stileId, Identifier fenceSideNorthId, Identifier fenceSideEastId, Identifier fenceSideSouthId, Identifier fenceSideWestId)
//    {
//        ModelVariantOperator r0 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R0);
//        ModelVariantOperator r90 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90);
//        ModelVariantOperator r180 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180);
//        ModelVariantOperator r270 = ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270);
//
//        ModelVariantOperator northSiding = ModelVariantOperator.MODEL.withValue(fenceSideNorthId);
//        ModelVariantOperator eastSiding = ModelVariantOperator.MODEL.withValue(fenceSideEastId);
//        ModelVariantOperator southSiding = ModelVariantOperator.MODEL.withValue(fenceSideSouthId);
//        ModelVariantOperator westSiding = ModelVariantOperator.MODEL.withValue(fenceSideWestId);
//
////        ModelVariantOperator uvlock = ModelVariantOperator.UV_LOCK.withValue(true);
//        return VariantsBlockModelDefinitionCreator.of(stileBlock).with(BlockStateVariantMap.models(Stile.FACING, Stile.NORTH, Stile.EAST, Stile.SOUTH, Stile.WEST)
//                .register(Direction.NORTH, false, false, false, false, stileId.apply(r0))
//                .register(Direction.SOUTH, false, false, false, false, stileId.apply(r180))
//                .register(Direction.EAST, false, false, false, false, stileId.apply(r90))
//                .register(Direction.WEST, false, false, false, false, stileId.apply(r270))
//
//                .register(Direction.NORTH, true, false, false, false, stileId.apply(r0).apply(northSiding))
//                .register(Direction.SOUTH, true, false, false, false, stileId.apply(r180).apply(northSiding))
//                .register(Direction.EAST, true, false, false, false, stileId.apply(r90).apply(northSiding))
//                .register(Direction.WEST, true, false, false, false, stileId.apply(r270).apply(northSiding))
//
//                .register(Direction.NORTH, true, true, false, false, stileId.apply(r0).apply(northSiding).apply(eastSiding))
//                .register(Direction.SOUTH, true, true, false, false, stileId.apply(r180).apply(northSiding).apply(eastSiding))
//                .register(Direction.EAST, true, true, false, false, stileId.apply(r90).apply(northSiding).apply(eastSiding))
//                .register(Direction.WEST, true, true, false, false, stileId.apply(r270).apply(northSiding).apply(eastSiding))
//
//                .register(Direction.NORTH, true, false, true, false, stileId.apply(r0).apply(northSiding).apply(southSiding))
//                .register(Direction.SOUTH, true, false, true, false, stileId.apply(r180).apply(northSiding).apply(southSiding))
//                .register(Direction.EAST, true, false, true, false, stileId.apply(r90).apply(northSiding).apply(southSiding))
//                .register(Direction.WEST, true, false, true, false, stileId.apply(r270).apply(northSiding).apply(southSiding))
//
//                .register(Direction.NORTH, true, false, false, true, stileId.apply(r0).apply(northSiding).apply(westSiding))
//                .register(Direction.SOUTH, true, false, false, true, stileId.apply(r180).apply(northSiding).apply(westSiding))
//                .register(Direction.EAST, true, false, false, true, stileId.apply(r90).apply(northSiding).apply(westSiding))
//                .register(Direction.WEST, true, false, false, true, stileId.apply(r270).apply(northSiding).apply(westSiding))
//
//                .register(Direction.NORTH, true, true, true, false, stileId.apply(r0).apply(northSiding).apply(eastSiding).apply(southSiding))
//                .register(Direction.SOUTH, true, true, true, false, stileId.apply(r180).apply(northSiding).apply(eastSiding).apply(southSiding))
//                .register(Direction.EAST, true, true, true, false, stileId.apply(r90).apply(northSiding).apply(eastSiding).apply(southSiding))
//                .register(Direction.WEST, true, true, true, false, stileId.apply(r270).apply(northSiding).apply(eastSiding).apply(southSiding))
//
//                .register(Direction.NORTH, true, true, false, true, stileId.apply(r0).apply(northSiding).apply(eastSiding).apply(westSiding))
//                .register(Direction.SOUTH, true, true, false, true, stileId.apply(r180).apply(northSiding).apply(eastSiding).apply(westSiding))
//                .register(Direction.EAST, true, true, false, true, stileId.apply(r90).apply(northSiding).apply(eastSiding).apply(westSiding))
//                .register(Direction.WEST, true, true, false, true, stileId.apply(r270).apply(northSiding).apply(eastSiding).apply(westSiding))
//
//                .register(Direction.NORTH, true, false, true, true, stileId.apply(r0).apply(northSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.SOUTH, true, false, true, true, stileId.apply(r180).apply(northSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.EAST, true, false, true, true, stileId.apply(r90).apply(northSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.WEST, true, false, true, true, stileId.apply(r270).apply(northSiding).apply(southSiding).apply(westSiding))
//
//                .register(Direction.NORTH, true, true, true, true, stileId.apply(r0).apply(northSiding).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.SOUTH, true, true, true, true, stileId.apply(r180).apply(northSiding).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.EAST, true, true, true, true, stileId.apply(r90).apply(northSiding).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.WEST, true, true, true, true, stileId.apply(r270).apply(northSiding).apply(eastSiding).apply(southSiding).apply(westSiding))
//
//                .register(Direction.NORTH, false, true, false, false, stileId.apply(r0).apply(eastSiding))
//                .register(Direction.SOUTH, false, true, false, false, stileId.apply(r180).apply(eastSiding))
//                .register(Direction.EAST, false, true, false, false, stileId.apply(r90).apply(eastSiding))
//                .register(Direction.WEST, false, true, false, false, stileId.apply(r270).apply(eastSiding))
//
//                .register(Direction.NORTH, false, true, true, false, stileId.apply(r0).apply(eastSiding).apply(southSiding))
//                .register(Direction.SOUTH, false, true, true, false, stileId.apply(r180).apply(eastSiding).apply(southSiding))
//                .register(Direction.EAST, false, true, true, false, stileId.apply(r90).apply(eastSiding).apply(southSiding))
//                .register(Direction.WEST, false, true, true, false, stileId.apply(r270).apply(eastSiding).apply(southSiding))
//
//                .register(Direction.NORTH, false, true, false, true, stileId.apply(r0).apply(eastSiding).apply(westSiding))
//                .register(Direction.SOUTH, false, true, false, true, stileId.apply(r180).apply(eastSiding).apply(westSiding))
//                .register(Direction.EAST, false, true, false, true, stileId.apply(r90).apply(eastSiding).apply(westSiding))
//                .register(Direction.WEST, false, true, false, true, stileId.apply(r270).apply(eastSiding).apply(westSiding))
//
//                .register(Direction.NORTH, false, true, true, true, stileId.apply(r0).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.SOUTH, false, true, true, true, stileId.apply(r180).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.EAST, false, true, true, true, stileId.apply(r90).apply(eastSiding).apply(southSiding).apply(westSiding))
//                .register(Direction.WEST, false, true, true, true, stileId.apply(r270).apply(eastSiding).apply(southSiding).apply(westSiding))
//
//                .register(Direction.NORTH, false, false, true, false, stileId.apply(r0).apply(southSiding))
//                .register(Direction.SOUTH, false, false, true, false, stileId.apply(r180).apply(southSiding))
//                .register(Direction.EAST, false, false, true, false, stileId.apply(r90).apply(southSiding))
//                .register(Direction.WEST, false, false, true, false, stileId.apply(r270).apply(southSiding))
//
//                .register(Direction.NORTH, false, false, true, true, stileId.apply(r0).apply(southSiding).apply(westSiding))
//                .register(Direction.SOUTH, false, false, true, true, stileId.apply(r180).apply(southSiding).apply(westSiding))
//                .register(Direction.EAST, false, false, true, true, stileId.apply(r90).apply(southSiding).apply(westSiding))
//                .register(Direction.WEST, false, false, true, true, stileId.apply(r270).apply(southSiding).apply(westSiding))
//
//                .register(Direction.NORTH, false, false, false, true, stileId.apply(r0).apply(westSiding))
//                .register(Direction.SOUTH, false, false, false, true, stileId.apply(r180).apply(westSiding))
//                .register(Direction.EAST, false, false, false, true, stileId.apply(r90).apply(westSiding))
//                .register(Direction.WEST, false, false, false, true, stileId.apply(r270).apply(westSiding))
//
//
//
//        );
//    }

    public static WeightedVariant varOf(Identifier id)
    {
        return BlockStateModelGenerator.createWeightedVariant(id);
    }

    private static Model block(String parent, TextureKey... requiredTextureKeys)
    {
        return new Model(Optional.of(Identifier.of(StylishStiles.MOD_ID, "block/" + parent)), Optional.empty(), requiredTextureKeys);
    }

    private static Model block(String parent, String variant, TextureKey... requiredTextureKeys)
    {
        return new Model(Optional.of(Identifier.of(StylishStiles.MOD_ID, "block/" + parent)), Optional.of(variant), requiredTextureKeys);
    }

    public static TextureMap blockTexture(Block block)
    {
        return new TextureMap().put(TextureKey.TEXTURE, ModelIds.getBlockModelId(block));
    }
}
