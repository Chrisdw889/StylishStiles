package net.weaverfever.stylishstiles;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.weaverfever.stylishstiles.block.ModBlocks;
import net.weaverfever.stylishstiles.item.ModItems;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StylishStiles.MOD_ID)
public class StylishStiles {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "stylishstiles";
    // Directly reference a slf4j logger

    public StylishStiles() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.OAK_STILE);
            event.accept(ModBlocks.ACACIA_STILE);
            event.accept(ModBlocks.DARK_OAK_STILE);
            event.accept(ModBlocks.SPRUCE_STILE);
            event.accept(ModBlocks.BIRCH_STILE);
            event.accept(ModBlocks.JUNGLE_STILE);
            event.accept(ModBlocks.CRIMSON_STILE);
            event.accept(ModBlocks.WARPED_STILE);
            event.accept(ModBlocks.MANGROVE_STILE);
            event.accept(ModBlocks.BAMBOO_STILE);
            event.accept(ModBlocks.CHERRY_STILE);
        }
    }
}
