package net.weaverfever.stylishstiles.data;

import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.weaverfever.stylishstiles.block.ModBlocks;

public class StileRecipeGenerator extends RecipeGenerator {

    private final RegistryEntryLookup<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);


    public StileRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    @Override
    public void generate() {
        WoodenStileRecipe(ModBlocks.OAK_STILE, Blocks.OAK_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.ACACIA_STILE, Blocks.ACACIA_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.DARK_OAK_STILE, Blocks.DARK_OAK_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.SPRUCE_STILE, Blocks.SPRUCE_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.BIRCH_STILE, Blocks.BIRCH_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.JUNGLE_STILE, Blocks.JUNGLE_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.CRIMSON_STILE, Blocks.CRIMSON_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.WARPED_STILE, Blocks.WARPED_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.MANGROVE_STILE, Blocks.MANGROVE_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.BAMBOO_STILE, Blocks.BAMBOO_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.CHERRY_STILE, Blocks.CHERRY_PLANKS).offerTo(exporter);
        WoodenStileRecipe(ModBlocks.PALE_OAK_STILE, Blocks.PALE_OAK_PLANKS).offerTo(exporter);

        StileRecipe(ModBlocks.NETHER_BRICK_STILE, Blocks.NETHER_BRICKS, Items.NETHER_BRICK).offerTo(exporter);
    }

    public CraftingRecipeJsonBuilder WoodenStileRecipe(ItemConvertible output, ItemConvertible input) {
        return ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, output, 1)
                .group("wooden_stile")
                .input('W', input)
                .input('#', Items.STICK)
                .pattern("WWW")
                .pattern("W#W")
                .criterion(hasItem(input), conditionsFromItem(input))
                .showNotification(true);
    }

    public CraftingRecipeJsonBuilder StileRecipe(ItemConvertible output, ItemConvertible input, ItemConvertible input2) {
        return ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, output, 1)
                .input('W', input)
                .input('#', input2)
                .pattern("W#W")
                .criterion(hasItem(input), conditionsFromItem(input))
                .showNotification(true);
    }
}
