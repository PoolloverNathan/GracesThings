package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.*.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Helpers {
    public static String MODID;

    public static Item registerItem(String name, FabricItemSettings settings) {
        return registerItem(name, new Item(settings));
    }
    public static Item registerItem(String name, ItemGroup group) {
        return registerItem(name, new FabricItemSettings().group(group));
    }
    public static Item registerItem(String name) {
        return registerItem(name, ItemGroup.MISC);
    }
    public static Item registerItem(String[] name) {
        for (String n : name) {
            return registerItem(n);
        }
    }
    public static Item registerItem(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
        return item;
    }

    public static Block registerBlock(String name, Material mat, int hardness) {
        return registerBlock(name, FabricBlockSettings.of(mat).hardness(hardness));
    }
    public static Block registerBlock(String name) {
        return registerBlock(name, tweaker.tweak(FabricBlockSettings.of(mat).hardness(hardness)));
    }
    public static Block registerBlock(String name, FabricBlockSettings settings) {
        return registerBlock(name, new Block(settings));
    }
    public static Block registerBlock(String[] name) {
        for (var n : name) {
            return registerBlock(n);
        }
    }
    public static Block registerBlock(String name, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
        return block;
    }
}