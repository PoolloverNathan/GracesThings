package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Helpers {
    public static String MODID;
    public static Item registerItem(String name, FabricItemSettings settings) {
        Item item = new Item(settings);
        Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
        return item;
    }
    public static Item registerItem(String name, ItemGroup group) {
        return registerItem(name, new FabricItemSettings().group(group));
    }
    public static Item registerItem(String name) {
        return registerItem(name, ItemGroup.MISC);
    }

    public static Item registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
        return item;
    }
}