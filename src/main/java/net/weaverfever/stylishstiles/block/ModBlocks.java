package net.weaverfever.stylishstiles.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.RegistryObject;
import net.weaverfever.stylishstiles.StylishStiles;
import net.weaverfever.stylishstiles.block.custom.Stile;
import net.weaverfever.stylishstiles.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StylishStiles.MOD_ID);

    public static final RegistryObject<Block> OAK_STILE = registerBlock("oak_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> ACACIA_STILE = registerBlock("acacia_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.ACACIA_FENCE)));
    public static final RegistryObject<Block> DARK_OAK_STILE = registerBlock("dark_oak_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.DARK_OAK_FENCE)));
    public static final RegistryObject<Block> SPRUCE_STILE = registerBlock("spruce_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<Block> BIRCH_STILE = registerBlock("birch_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.BIRCH_FENCE)));
    public static final RegistryObject<Block> JUNGLE_STILE = registerBlock("jungle_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.JUNGLE_FENCE)));
    public static final RegistryObject<Block> CRIMSON_STILE = registerBlock("crimson_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.CRIMSON_FENCE)));
    public static final RegistryObject<Block> WARPED_STILE = registerBlock("warped_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.WARPED_FENCE)));
    public static final RegistryObject<Block> NETHER_BRICK_STILE = registerBlock("nether_brick_stile",
            () -> new Stile(AbstractBlock.Properties.from(Blocks.NETHER_BRICK_FENCE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
