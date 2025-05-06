package net.weaverfever.stylishstiles.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.weaverfever.stylishstiles.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {


    public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.OAK_STILE, "Oak Stile");
        translationBuilder.add(ModBlocks.ACACIA_STILE, "Acacia Stile");
        translationBuilder.add(ModBlocks.DARK_OAK_STILE, "Dark Oak Stile");
        translationBuilder.add(ModBlocks.SPRUCE_STILE, "Spruce Stile");
        translationBuilder.add(ModBlocks.BIRCH_STILE, "Birch Stile");
        translationBuilder.add(ModBlocks.JUNGLE_STILE, "Jungle Stile");
        translationBuilder.add(ModBlocks.CRIMSON_STILE, "Crimson Stile");
        translationBuilder.add(ModBlocks.WARPED_STILE, "Warped Stile");
        translationBuilder.add(ModBlocks.MANGROVE_STILE, "Mangrove Stile");
        translationBuilder.add(ModBlocks.BAMBOO_STILE, "Bamboo Stile");
        translationBuilder.add(ModBlocks.CHERRY_STILE, "Cherry Stile");
        translationBuilder.add(ModBlocks.PALE_OAK_STILE, "Pale Oak Stile");

        translationBuilder.add(ModBlocks.NETHER_BRICK_STILE, "Nether Brick Stile");
    }
}
