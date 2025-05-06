package net.weaverfever.stylishstiles.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.weaverfever.stylishstiles.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.OAK_STILE);
        addDrop(ModBlocks.ACACIA_STILE);
        addDrop(ModBlocks.DARK_OAK_STILE);
        addDrop(ModBlocks.SPRUCE_STILE);
        addDrop(ModBlocks.BIRCH_STILE);
        addDrop(ModBlocks.JUNGLE_STILE);
        addDrop(ModBlocks.CRIMSON_STILE);
        addDrop(ModBlocks.WARPED_STILE);
        addDrop(ModBlocks.MANGROVE_STILE);
        addDrop(ModBlocks.BAMBOO_STILE);
        addDrop(ModBlocks.CHERRY_STILE);
        addDrop(ModBlocks.PALE_OAK_STILE);

        addDrop(ModBlocks.NETHER_BRICK_STILE);
    }
}
