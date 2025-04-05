package net.weaverfever.stylishstiles;

import net.fabricmc.api.ModInitializer;
import net.weaverfever.stylishstiles.block.ModBlocks;
import net.weaverfever.stylishstiles.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StylishStiles implements ModInitializer {
	public static final String MOD_ID = "stylishstiles";
	public static final Logger LOGGER = LoggerFactory.getLogger("stylishstiles");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}