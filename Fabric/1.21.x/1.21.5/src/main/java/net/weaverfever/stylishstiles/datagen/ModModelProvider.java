package net.weaverfever.stylishstiles.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.weaverfever.stylishstiles.block.ModBlocks;
import net.weaverfever.stylishstiles.models.ModBlockStateModelGenerator;
import net.weaverfever.stylishstiles.models.ModTextureMaps;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator bsmg) {
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.OAK_STILE, Blocks.OAK_FENCE, ModTextureMaps.stileTexture(Blocks.OAK_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.ACACIA_STILE, Blocks.DARK_OAK_FENCE, ModTextureMaps.stileTexture(Blocks.ACACIA_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.DARK_OAK_STILE, Blocks.DARK_OAK_FENCE, ModTextureMaps.stileTexture(Blocks.DARK_OAK_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.SPRUCE_STILE, Blocks.SPRUCE_FENCE, ModTextureMaps.stileTexture(Blocks.SPRUCE_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.BIRCH_STILE, Blocks.BIRCH_FENCE, ModTextureMaps.stileTexture(Blocks.BIRCH_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.JUNGLE_STILE, Blocks.JUNGLE_FENCE, ModTextureMaps.stileTexture(Blocks.JUNGLE_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.CRIMSON_STILE, Blocks.CRIMSON_FENCE, ModTextureMaps.stileTexture(Blocks.CRIMSON_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.WARPED_STILE, Blocks.WARPED_FENCE, ModTextureMaps.stileTexture(Blocks.WARPED_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.MANGROVE_STILE, Blocks.MANGROVE_FENCE, ModTextureMaps.stileTexture(Blocks.MANGROVE_PLANKS));
        ModBlockStateModelGenerator.registerCustomStile(bsmg, ModBlocks.BAMBOO_STILE, Blocks.BAMBOO_FENCE, ModTextureMaps.customStileTexture(Blocks.BAMBOO_FENCE));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.CHERRY_STILE, Blocks.CHERRY_FENCE, ModTextureMaps.stileTexture(Blocks.CHERRY_PLANKS));
        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.PALE_OAK_STILE, Blocks.PALE_OAK_FENCE, ModTextureMaps.stileTexture(Blocks.PALE_OAK_PLANKS));

        ModBlockStateModelGenerator.registerStile(bsmg, ModBlocks.NETHER_BRICK_STILE, Blocks.NETHER_BRICK_FENCE, ModTextureMaps.stileTexture(Blocks.NETHER_BRICKS));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.);
    }
}
