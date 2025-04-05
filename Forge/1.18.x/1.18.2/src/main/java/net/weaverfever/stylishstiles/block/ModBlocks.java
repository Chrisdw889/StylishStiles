package net.weaverfever.stylishstiles.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.weaverfever.stylishstiles.StylishStiles;
import net.weaverfever.stylishstiles.block.custom.Stile;
import net.weaverfever.stylishstiles.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StylishStiles.MOD_ID);

    public static final RegistryObject<Block> OAK_STILE = registerBlock("oak_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ACACIA_STILE = registerBlock("acacia_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.ACACIA_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_OAK_STILE = registerBlock("dark_oak_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SPRUCE_STILE = registerBlock("spruce_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.SPRUCE_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BIRCH_STILE = registerBlock("birch_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JUNGLE_STILE = registerBlock("jungle_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.JUNGLE_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CRIMSON_STILE = registerBlock("crimson_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.CRIMSON_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WARPED_STILE = registerBlock("warped_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.WARPED_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> NETHER_BRICK_STILE = registerBlock("nether_brick_stile",
            () -> new Stile(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICK_FENCE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
