package net.weaverfever.stylishstiles.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.weaverfever.stylishstiles.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .setReplace(false)
                .add(ModBlocks.OAK_STILE)
                .add(ModBlocks.ACACIA_STILE)
                .add(ModBlocks.DARK_OAK_STILE)
                .add(ModBlocks.SPRUCE_STILE)
                .add(ModBlocks.BIRCH_STILE)
                .add(ModBlocks.JUNGLE_STILE)
                .add(ModBlocks.CRIMSON_STILE)
                .add(ModBlocks.WARPED_STILE)
                .add(ModBlocks.MANGROVE_STILE)
                .add(ModBlocks.BAMBOO_STILE)
                .add(ModBlocks.CHERRY_STILE)
                .add(ModBlocks.PALE_OAK_STILE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .setReplace(false)
                .add(ModBlocks.NETHER_BRICK_STILE);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.NETHER_BRICK_STILE);
    }
}
