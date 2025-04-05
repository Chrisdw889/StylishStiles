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
//        getOrCreateTagBuilder(BlockTags.FENCES)
//                .add(ModBlocks.OAK_STILE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .setReplace(false)
                .add(ModBlocks.OAK_STILE);
        // Adds Mod blocks to the pickaxe mineable block tags
//        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.INSERT MOD BLOCK)
    }
}
