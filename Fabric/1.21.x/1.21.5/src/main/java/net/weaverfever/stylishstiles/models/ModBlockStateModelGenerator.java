package net.weaverfever.stylishstiles.models;

import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.MultipartModelConditionBuilder;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;
import net.weaverfever.stylishstiles.block.custom.Stile;

public class ModBlockStateModelGenerator {


    public static void registerStile(BlockStateModelGenerator generator, Block stileBlock, Block matchingFence, TextureMap textures)
    {
        Identifier stileModel = ModModels.STILE.upload(stileBlock, textures, generator.modelCollector);
        String parentId = Registries.BLOCK.getEntry(matchingFence).getIdAsString().replaceAll("minecraft:", "");
        Identifier fenceSideModel = Identifier.ofVanilla("block/" + parentId + "_side");
        generator.blockStateCollector.accept(createStileBlockStates(stileBlock, varOf(stileModel), varOf(fenceSideModel)));
        generator.registerParentedItemModel(stileBlock, stileModel);
    }

    public static void registerCustomStile(BlockStateModelGenerator generator, Block customStileBlock, Block matchingFence, TextureMap textures)
    {
        Identifier customStileModel = ModModels.CUSTOM_STILE.upload(customStileBlock, textures, generator.modelCollector);
        String parentId = Registries.BLOCK.getEntry(matchingFence).getIdAsString().replaceAll("minecraft:", "");
        Identifier fenceSideNorthModel = Identifier.ofVanilla( "block/" + parentId + "_side_north");
        Identifier fenceSideEastModel = Identifier.ofVanilla( "block/" + parentId + "_side_east");
        Identifier fenceSideSouthModel = Identifier.ofVanilla( "block/" + parentId + "_side_south");
        Identifier fenceSideWestModel = Identifier.ofVanilla( "block/" + parentId + "_side_west");
        generator.blockStateCollector.accept(createCustomStileBlockStates(
                customStileBlock,
                varOf(customStileModel),
                varOf(fenceSideNorthModel),
                varOf(fenceSideEastModel),
                varOf(fenceSideSouthModel),
                varOf(fenceSideWestModel)
        ));
        generator.registerParentedItemModel(customStileBlock, customStileModel);
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

    private static MultipartBlockModelDefinitionCreator createCustomStileBlockStates(
            Block stileBlock,
            WeightedVariant stileId,
            WeightedVariant fenceNorthSideId,
            WeightedVariant fenceEastSideId,
            WeightedVariant fenceSouthSideId,
            WeightedVariant fenceWestSideId)
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
                .with(northConnectionCondition, fenceNorthSideId.apply(uvlock))
                .with(eastConnectionCondition, fenceEastSideId.apply(uvlock))
                .with(southConnectionCondition, fenceSouthSideId.apply(uvlock))
                .with(westConnectionCondition, fenceWestSideId.apply(uvlock));
    }



    public static WeightedVariant varOf(Identifier id)
    {
        return BlockStateModelGenerator.createWeightedVariant(id);
    }



}
