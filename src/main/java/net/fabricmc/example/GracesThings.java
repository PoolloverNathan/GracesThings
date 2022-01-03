package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.fabricmc.example.Helpers.registerItem;

public class GracesThings implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "gracesthings";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Helpers.MODID = MODID;
		final Item DIRTY_CUPCAKE_WRAPPER = registerItem("dirty_cupcake_wrapper", ItemGroup.MATERIALS);

		registerItem("money");
		registerItem("cupcake_wrapper", ItemGroup.MATERIALS);
		registerItem("cupcake", new FoodRemainderItem(new FabricItemSettings().group(ItemGroup.FOOD).food(new FoodComponent.Builder().hunger(2).saturationModifier(3).snack().build()), DIRTY_CUPCAKE_WRAPPER));
		registerItem("trader_beacon", new TraderBeacon(new FabricItemSettings().group(ItemGroup.TOOLS)));

		LOGGER.info("Hello Fabric world!");

	}
}
