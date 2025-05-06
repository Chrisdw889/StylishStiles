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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.weaverfever.stylishstiles.StylishStiles;
import net.weaverfever.stylishstiles.block.custom.Stile;

import java.util.function.Function;

public class ModBlocks {



    public static final Block OAK_STILE = registerBlock("oak_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.OAK_FENCE));
    public static final Block ACACIA_STILE = registerBlock("acacia_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.ACACIA_FENCE));
    public static final Block DARK_OAK_STILE = registerBlock("dark_oak_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.DARK_OAK_FENCE));
    public static final Block SPRUCE_STILE = registerBlock("spruce_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.SPRUCE_FENCE));
    public static final Block BIRCH_STILE = registerBlock("birch_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.BIRCH_FENCE));
    public static final Block JUNGLE_STILE = registerBlock("jungle_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.JUNGLE_FENCE));
    public static final Block CRIMSON_STILE = registerBlock("crimson_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.CRIMSON_FENCE));
    public static final Block WARPED_STILE = registerBlock("warped_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.WARPED_FENCE));
    public static final Block MANGROVE_STILE = registerBlock("mangrove_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.MANGROVE_FENCE));
    public static final Block BAMBOO_STILE = registerBlock("bamboo_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.BAMBOO_FENCE));
    public static final Block CHERRY_STILE = registerBlock("cherry_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.CHERRY_FENCE));
    public static final Block PALE_OAK_STILE = registerBlock("pale_oak_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.PALE_OAK_FENCE));

    public static final Block NETHER_BRICK_STILE = registerBlock("nether_brick_stile", Stile::new, AbstractBlock.Settings.copy(Blocks.NETHER_BRICK_FENCE));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksItemGroup);
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {

        Block block = blockFactory.apply(settings.registryKey(keyOfBlock(name)));

        Registry.register(Registries.ITEM, Identifier.of(StylishStiles.MOD_ID, name), new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(keyOfItem(name))));

        return Registry.register(Registries.BLOCK, keyOfBlock(name), block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(StylishStiles.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StylishStiles.MOD_ID, name));
    }

    private static void addBlocksToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        entries.add(OAK_STILE);
        entries.add(ACACIA_STILE);
        entries.add(DARK_OAK_STILE);
        entries.add(SPRUCE_STILE);
        entries.add(BIRCH_STILE);
        entries.add(JUNGLE_STILE);
        entries.add(CRIMSON_STILE);
        entries.add(WARPED_STILE);
        entries.add(MANGROVE_STILE);
        entries.add(BAMBOO_STILE);
        entries.add(CHERRY_STILE);
        entries.add(PALE_OAK_STILE);
        entries.add(NETHER_BRICK_STILE);
    }

}
