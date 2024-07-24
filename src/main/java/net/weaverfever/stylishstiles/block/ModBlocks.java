package net.weaverfever.stylishstiles.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.weaverfever.stylishstiles.StylishStiles;
import net.weaverfever.stylishstiles.block.custom.Stile;

public class ModBlocks {

    private static final Block OAK_STILE = registerBlock("oak_stile", new Stile(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));
    private static final Block ACACIA_STILE = registerBlock("acacia_stile", new Stile(AbstractBlock.Settings.copy(Blocks.ACACIA_FENCE)));
    private static final Block DARK_OAK_STILE = registerBlock("dark_oak_stile", new Stile(AbstractBlock.Settings.copy(Blocks.DARK_OAK_FENCE)));
    private static final Block SPRUCE_STILE = registerBlock("spruce_stile", new Stile(AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE)));
    private static final Block BIRCH_STILE = registerBlock("birch_stile", new Stile(AbstractBlock.Settings.copy(Blocks.BIRCH_FENCE)));
    private static final Block JUNGLE_STILE = registerBlock("jungle_stile", new Stile(AbstractBlock.Settings.copy(Blocks.JUNGLE_FENCE)));
    private static final Block CRIMSON_STILE = registerBlock("crimson_stile", new Stile(AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE)));
    private static final Block WARPED_STILE = registerBlock("warped_stile", new Stile(AbstractBlock.Settings.copy(Blocks.WARPED_FENCE)));
    private static final Block MANGROVE_STILE = registerBlock("mangrove_stile", new Stile(AbstractBlock.Settings.copy(Blocks.MANGROVE_FENCE)));
    private static final Block BAMBOO_STILE = registerBlock("bamboo_stile", new Stile(AbstractBlock.Settings.copy(Blocks.BAMBOO_FENCE)));
    private static final Block CHERRY_STILE = registerBlock("cherry_stile", new Stile(AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE)));
    private static final Block NETHER_BRICK_STILE = registerBlock("nether_brick_stile", new Stile(AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StylishStiles.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(StylishStiles.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static void addBlocksToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(OAK_STILE);
        entries.add(ACACIA_STILE);
        entries.add(DARK_OAK_STILE);
        entries.add(BIRCH_STILE);
        entries.add(SPRUCE_STILE);
        entries.add(JUNGLE_STILE);
        entries.add(CRIMSON_STILE);
        entries.add(WARPED_STILE);
        entries.add(MANGROVE_STILE);
        entries.add(BAMBOO_STILE);
        entries.add(CHERRY_STILE);
        entries.add(NETHER_BRICK_STILE);

    }

    public static void registerModBlocks() {
        StylishStiles.LOGGER.info("Registering ModBlocks for  " + StylishStiles.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksItemGroup);
    }
}
