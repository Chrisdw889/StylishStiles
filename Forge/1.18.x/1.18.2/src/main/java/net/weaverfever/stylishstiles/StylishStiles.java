package net.weaverfever.stylishstiles;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
