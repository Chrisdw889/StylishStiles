package net.weaverfever.stylishstiles.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.weaverfever.stylishstiles.StylishStiles;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StylishStiles.MOD_ID, name), item);
    }
    public static void registerModItems() {
        StylishStiles.LOGGER.info("Registering Mod Items for " + StylishStiles.MOD_ID);
    }
}
