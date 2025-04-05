package net.weaverfever.stylishstiles;

import net.fabricmc.api.ModInitializer;

import net.weaverfever.stylishstiles.block.ModBlocks;
import net.weaverfever.stylishstiles.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StylishStiles implements ModInitializer {
	public static final String MOD_ID = "stylishstiles";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItems.initialize();
		ModBlocks.initialize();
	}
}